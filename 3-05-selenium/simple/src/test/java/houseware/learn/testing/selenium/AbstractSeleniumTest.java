package houseware.learn.testing.selenium;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    public  WebDriver driver;

    public String seleniumHQGrid;

    public WebDriver startDriver(int timeout) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setPlatform(Platform.ANY);
        if(this.seleniumHQGrid != null && !this.seleniumHQGrid.isEmpty()) {
            this.driver =  new RemoteWebDriver(new URL(this.seleniumHQGrid), desiredCapabilities);
        } else {
            try {
                this.driver = new FirefoxDriver();
            } catch (WebDriverException e) {
                throw new NullPointerException("Firefox is missing. Please install firefox");
            }
        }
        prepare(this.driver, timeout);
        return this.driver;
    }

    public void prepare(WebDriver driver, int timeout){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        if(this.driver != null) {
            this.driver.quit();
        }
    }


}
