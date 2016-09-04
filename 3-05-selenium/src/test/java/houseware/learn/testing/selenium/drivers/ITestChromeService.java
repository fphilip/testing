package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.AbstractSeleniumTest;
import houseware.learn.testing.ChromeTestUtils;
import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class ITestChromeService extends AbstractSeleniumTest {

    private static ChromeDriverService service;


    @BeforeClass
    public static void createAndStartService() throws IOException {

        ChromeTestUtils.configureDriver();
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

    @Override
    public WebDriver buildDriver() {
        return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());

    }

    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(getWebDriver());
    }

}