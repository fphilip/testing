package houseware.learn.testing.selenium.drivers;

import houseware.learn.testing.AbstractSeleniumTest;
import houseware.learn.testing.ChromeTestUtils;
import houseware.learn.testing.selenium.simple.GoogleTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ITestChromeDriver extends AbstractSeleniumTest {


    @Override
    public WebDriver buildDriver() {
        return ChromeTestUtils.newDriver();
    }


    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(getWebDriver());
    }


}