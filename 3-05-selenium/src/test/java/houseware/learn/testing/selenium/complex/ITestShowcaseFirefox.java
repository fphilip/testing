package houseware.learn.testing.selenium.complex;

import houseware.learn.testing.selenium.drivers.FirefoxTestUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class ITestShowcaseFirefox extends ITestShowcase {


    private static WebDriver webDriver;


    public WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeClass
    public static void createAndStartDriver() throws IOException {
        FirefoxTestUtils.configureMarionetteDriver();
    }

    @Before
    public void before() {
        webDriver = new MarionetteDriver();
    }


}
