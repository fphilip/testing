package houseware.learn.testing.phatomjs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ITestGoogleSearchPantomDriver extends AbstractPantomDriverTest {

    @After
    public void after_class() {
        quitDriver();
    }

    @Before
    public void before_class() throws MalformedURLException {
        startDriver(3);
    }

    @Test
    public void google_search_selenium(){

        this.driver.get("http://www.google.com/");

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        assertEquals("Google", this.driver.getTitle());

//        By input = By.xpath("//input[@id='lst-ib']");
//        WebElement inputElement = this.driver.findElement(input);
//        inputElement.sendKeys("Selenium - Web Browser Automation");



    }


}
