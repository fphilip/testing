package houseware.learn.testing.phatomjs;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPantomDriverTest {

    public  WebDriver driver;

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
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"/Users/fphilip/Downloads/phantomjs-2.1.1-macosx/bin/phantomjs");
        try {
            this.driver = new PhantomJSDriver(desiredCapabilities);
        } catch (WebDriverException e) {
            throw new NullPointerException("Phatomjs is missing. Please install firefox");
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
