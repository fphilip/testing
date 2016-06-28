package houseware.learn.testing.selenium.drivers;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class FirefoxTestUtils {

    public static Process execDriver() throws IOException {
        return Runtime.getRuntime().exec("/Users/fphilip/Downloads/geckodriver-0.8.0-OSX" /* " --connect-existing"*/);
    }

    public static void configureMarionetteDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/fphilip/Downloads/geckodriver-0.8.0-OSX");
    }


}
