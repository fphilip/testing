package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.selenium.AbstractSeleniumTest;
import houseware.learn.testing.selenium.complex.ITestShowcase;
import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ITestChromeService extends AbstractSeleniumTest {



    private static ChromeDriverService service;

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeClass
    public static void createAndStartService() throws IOException {

        ChromeTestUtils.configureChromeDriver();
        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    @Before
    public void createDriver() throws MalformedURLException {
        webDriver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
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