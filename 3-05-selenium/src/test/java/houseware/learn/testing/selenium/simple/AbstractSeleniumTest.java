package houseware.learn.testing.selenium.simple;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    public WebDriver driver;

    public String seleniumHQGrid;

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
//        desiredCapabilities.setCapability("marionette", true);

//        DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
//        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setPlatform(Platform.ANY);
        if (this.seleniumHQGrid != null && !this.seleniumHQGrid.isEmpty()) {
            this.driver = new RemoteWebDriver(new URL(this.seleniumHQGrid), desiredCapabilities);
        } else {
                this.driver = new FirefoxDriver();
//            this.driver = new SafariDriver();
//                this.driver = new ChromeDriver();
        }
        prepare(this.driver, timeout);
        return this.driver;
    }

    public void prepare(WebDriver driver, int timeout) {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }


}
