package houseware.learn.testing;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class AbstractSeleniumTest<T extends WebDriver> {

    @Getter
    @Setter
    T webDriver;

    public abstract T buildDriver();

    protected static final String SCREENSHOT_PATH = "target/test/screenshots/";
    @Rule
    public MethodRule screenshot = new ScreenshotOnTestFailure();
    boolean closeDriver = false;

    public String captureScreen() {
        return captureScreen(SCREENSHOT_PATH);
    }

    public String captureScreen(String filePath) {
        if (getWebDriver() != null) {
            try {
                File screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
                String completeFilePath = filePath + "_" + screenshot.getName();
                FileUtils.copyFile(screenshot, new File(completeFilePath));
                return completeFilePath;
            } catch (IOException e) {
                log.error("Failed to capture screenshot: " + e.getMessage());
            }
        } else {
            log.error("WebDriver is null");

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
                        closeDriver = false;
                        statement.evaluate();
                    } catch (Exception e) {
                        captureScreen(SCREENSHOT_PATH + frameworkMethod.getName());
                        throw e; // rethrow to allow the failure to be reported to JUnit
                    } finally {
                        closeDriver = true;
                        quitDriver();
                    }
                }
            };
        }
    }

    @After
    public void quitDriver() {
        if (closeDriver && getWebDriver() != null) {
            getWebDriver().quit();
        }
    }


    @Before
    public void setUp() {
        setWebDriver(buildDriver());
        getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void is_driver() {
        Assert.assertNotNull(getWebDriver());
    }

    public String getHost() {
        return "http://localhost/showcase";
    }

    public void open(String suffix) {
        getWebDriver().get(getHost() + suffix);
    }

}
