package houseware.learn.testing;

import org.openqa.selenium.firefox.MarionetteDriver;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assume.assumeThat;

/**
 * @author fphilip@houseware.es
 */
public class FirefoxTestUtils {

    //"/Users/fphilip/Downloads/geckodriver-0.8.0-OSX"
    public static void configure() {
        String firefoxPath = "C:/Users/apasc/Downloads/geckodriver.exe";
        assumeThat(new File(firefoxPath).exists(), is(true));
        System.setProperty("webdriver.gecko.driver", firefoxPath);
    }

    public static MarionetteDriver newDriver() {
        configure();

        //todo depends version
        return new MarionetteDriver();
//        return new FirefoxDriver();
    }


}
