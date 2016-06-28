package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.selenium.AbstractSeleniumTest;
import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

public class ITestSafariDriver extends AbstractSeleniumTest {

    private static WebDriver webDriver;


    public WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeClass
    public static void createAndStartDriver() throws IOException {
//        FirefoxTestUtils.configureMarionetteDriver();
        webDriver = new SafariDriver();
    }


    @After
    public void quitDriver() {
        webDriver.quit();
    }

    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(webDriver);
    }


}