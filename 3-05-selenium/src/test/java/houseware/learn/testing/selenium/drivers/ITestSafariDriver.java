package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.AbstractSeleniumTest;
import houseware.learn.testing.SafariTestUtils;
import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ITestSafariDriver extends AbstractSeleniumTest {

    @Override
    public WebDriver buildDriver() {
        return SafariTestUtils.newDriver();
    }

    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(getWebDriver());
    }


}