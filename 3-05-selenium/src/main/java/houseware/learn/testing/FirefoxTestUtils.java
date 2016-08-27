package houseware.learn.testing;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class FirefoxTestUtils {

    public static Process exec() throws IOException {
        return Runtime.getRuntime().exec("/Users/fphilip/Downloads/geckodriver-0.8.0-OSX" /* " --connect-existing"*/);
    }

    public static void configure() {
        System.setProperty("webdriver.gecko.driver", "/Users/fphilip/Downloads/geckodriver-0.8.0-OSX");
    }

    public static MarionetteDriver newDriver() {
        configure();

        //todo depends version
        return new MarionetteDriver();
//        return new FirefoxDriver();
    }


}
