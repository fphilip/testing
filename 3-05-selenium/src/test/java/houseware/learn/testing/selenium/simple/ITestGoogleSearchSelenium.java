package houseware.learn.testing.selenium.simple;

import org.junit.Test;

public class ITestGoogleSearchSelenium extends AbstractSeleniumTest {


    @Test
    public void testGoogleSearch() throws InterruptedException {
        GoogleTest.google_search_1(driver);
    }

    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(driver);
    }

}
