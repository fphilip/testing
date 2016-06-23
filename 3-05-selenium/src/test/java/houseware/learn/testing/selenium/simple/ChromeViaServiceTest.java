package houseware.learn.testing.selenium.simple;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeViaServiceTest {

    private static ChromeDriverService service;

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeClass
    public static void createAndStartService() throws IOException {
        System.setProperty("webdriver.chrome.webDriver", "/Users/fphilip/Downloads/chromedriver");
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"))
                .usingAnyFreePort()
//                .withVerbose(true)
//                .withLogFile(new File("./chrome.log"))
                .build();
//        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    @Before
    public void createDriver() throws MalformedURLException {
//        webDriver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
//        webDriver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    }

    @After
    public void quitDriver() {
        webDriver.quit();
    }
    @Test
    public void is_ok(){

    }

}