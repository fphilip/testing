package houseware.learn.testing.selenium.complex;

import houseware.learn.testing.selenium.drivers.ChromeTestUtils;
import houseware.learn.testing.selenium.drivers.FirefoxTestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class ITestShowcaseChrome extends ITestShowcase {


    private static WebDriver webDriver;


      public WebDriver getWebDriver() {
          return webDriver;
      }

      @BeforeClass
      public static void createAndStartDriver() throws IOException {
          ChromeTestUtils.configureDriver();
      }



    @Before
    public void before() {
        webDriver = new ChromeDriver();
    }

}
