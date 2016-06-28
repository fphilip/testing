package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import java.net.URL;

/**
 * @author fphilip@houseware.es
 */
public class ITestRemoteDriver {
    protected static WebDriver webDriver;
    protected static SeleniumServer server;

    @BeforeClass
    public static void setUpTest() throws Exception {
        RemoteControlConfiguration conf = new RemoteControlConfiguration();
        conf.setPort(4444);
        conf.setDebugURL("/wd/hub");
        server = new SeleniumServer(conf);
        server.start();
        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                        DesiredCapabilities.chrome());
    }

    @AfterClass
    public static void tearDownTest() {
        server.stop();
    }



    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(webDriver);
    }


}
