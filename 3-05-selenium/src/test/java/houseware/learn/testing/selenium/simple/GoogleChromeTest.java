package houseware.learn.testing.selenium.simple;

import houseware.learn.testing.selenium.drivers.ITestChromeService;
import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class GoogleChromeTest extends ITestChromeService {


    @Test
    public void testGoogleSearch() throws InterruptedException {
        GoogleTest.google_search_1(getWebDriver());
    }

    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(getWebDriver());
    }

}
