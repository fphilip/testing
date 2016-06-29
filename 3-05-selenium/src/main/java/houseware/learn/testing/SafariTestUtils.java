package houseware.learn.testing;

import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class SafariTestUtils {

    public static Process exec() throws IOException {
        return Runtime.getRuntime().exec("/Users/fphilip/Downloads/geckodriver-0.8.0-OSX" /* " --connect-existing"*/);
    }

    public static void configure() {
        System.setProperty("webdriver.gecko.driver", "/Users/fphilip/Downloads/geckodriver-0.8.0-OSX");
    }
    public static SafariDriver newDriver() {
        configure();
        return  new SafariDriver();
    }

//

}
