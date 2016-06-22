package houseware.learn.testing.selenium.simple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

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
