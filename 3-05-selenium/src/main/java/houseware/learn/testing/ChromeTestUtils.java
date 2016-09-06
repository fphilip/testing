package houseware.learn.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.core.Is.is;

import java.io.File;

import static org.junit.Assume.assumeThat;

/**
 * @author fphilip@houseware.es
 */
public class ChromeTestUtils {

    public static void configureDriver() {
        String chromePath = "C:/Users/apasc/Downloads/chromedriver.exe";
        assumeThat(new File(chromePath).exists(), is(true));
        System.setProperty("webdriver.chrome.driver", chromePath);
    }

    public static WebDriver newDriver() {
        configureDriver();
        return new ChromeDriver();
    }
}
