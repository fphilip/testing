package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.selenium.AbstractSeleniumTest;
import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ITestChromeDriver extends AbstractSeleniumTest {

    private static WebDriver webDriver;


    public WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeClass
    public static void createAndStartDriver() throws IOException {
        ChromeTestUtils.configureChromeDriver();
        webDriver = new ChromeDriver();
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