package houseware.learn.testing.selenium.complex;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//@Slf4j
public abstract class AbstractSeleniumTest {


    protected static final String SCREENSHOT_PATH = "target/test/screenshots/";
    @Rule
    public MethodRule screenshot = new ScreenshotOnTestFailure();


    private WebDriver driver;

    private String seleniumHQGrid;

    public WebDriver getWebDriver() {
        return driver;
    }

    @After
    public void after_class() {
        quitDriver();
    }

    @Before
    public void before_class() throws MalformedURLException {
        startDriver(3);
    }

    public WebDriver startDriver(int timeout) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setPlatform(Platform.ANY);
        if (this.seleniumHQGrid != null && !this.seleniumHQGrid.isEmpty()) {
           driver = new RemoteWebDriver(new URL(this.seleniumHQGrid), desiredCapabilities);
        } else {
            try {
                driver = new FirefoxDriver();
            } catch (WebDriverException e) {
                throw new NullPointerException("Firefox is missing. Please install firefox");
            }
        }
        prepare(getWebDriver(), timeout);
        return getWebDriver();
    }

    public void prepare(WebDriver driver, int timeout) {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }


    public String captureScreen() {
        return captureScreen(SCREENSHOT_PATH);
    }

    public String captureScreen(String filePath) {
        try {
            File screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            String completeFilePath = filePath + "_" + screenshot.getName();
            FileUtils.copyFile(screenshot, new File(completeFilePath));
            return completeFilePath;
        } catch (IOException e) {
//            log.error("Failed to capture screenshot: " + e.getMessage());
        }

        return null;
    }

    public String captureWindowElement(WebElement element) {
        return captureWindowElement(element, SCREENSHOT_PATH);
    }

    public String captureWindowElement(WebElement element, String filePath) {
        try {
            WrapsDriver wrapsDriver = (WrapsDriver) element;
            File screenshot = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
            java.awt.Rectangle rectangle = new java.awt.Rectangle(element.getSize().width, element.getSize().height);
            Point location = element.getLocation();
            BufferedImage bufferedImage = ImageIO.read(screenshot);
            BufferedImage destImage = bufferedImage.getSubimage(location.x, location.y, rectangle.width, rectangle.height);
            ImageIO.write(destImage, "png", screenshot);
            String completeFilePath = filePath + "_" + screenshot.getName();
            File file = new File(completeFilePath);
            FileUtils.copyFile(screenshot, file);
            return completeFilePath;
        } catch (IOException e) {
//            log.error("Failed to capture screenshot: " + e.getMessage());
        }

        return null;
    }

    public class ScreenshotOnTestFailure implements MethodRule {
        @Override
        public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, Object o) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
//                        setCloseWebDriver(false);
                        statement.evaluate();
                    } catch (Exception e) {
                        captureScreen(SCREENSHOT_PATH + frameworkMethod.getName());
                        throw e; // rethrow to allow the failure to be reported to JUnit
                    } finally {
//                        closeWebDriver();
                    }
                }
            };
        }
    }


}
