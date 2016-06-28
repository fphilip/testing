package houseware.learn.testing.selenium.drivers;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class ChromeTestUtils {

    public static Process execDriver() throws IOException {
        return Runtime.getRuntime().exec("/Users/fphilip/Downloads/chromedirver");
    }

    public static void configureDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/fphilip/Downloads/chromedriver");
    }
}
