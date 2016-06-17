package houseware.learn.testing.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ITestGoogleSearchSelenium extends AbstractSeleniumTest {

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
        By input = By.id("lst-ib");
        WebElement inputElement = this.driver.findElement(input);
        inputElement.sendKeys("Selenium - Web Browser Automation");

        By botton = By.cssSelector(".lsb");

        WebElement bottonElement = this.driver.findElement(botton);
        bottonElement.click();

        By result = By.xpath("//div[@class='srg']/div[1]");

        WebElement resultElement = this.driver.findElement(result);

        String fristfound = resultElement.getText();
        String expected = "Selenium - Web Browser Automation\nwww.seleniumhq.org/\nTraducir esta página\nSite of web browser automation tool with .NET provider and related documentation.\nDownloads · Documentation · Selenium WebDriver · Selenium IDE";

        assertEquals("The frist result not is the expected", fristfound, expected);


    }

    @Test
    public void google_search_showcase(){
        this.driver.get("http://www.google.com/");
        By input = By.id("lst-ib");
        WebElement inputElement = this.driver.findElement(input);
        inputElement.sendKeys("PrimeFaces ShowCase");

        By botton = By.cssSelector(".lsb");

        WebElement bottonElement = this.driver.findElement(botton);
        bottonElement.click();

        By result = By.xpath("//div[@class='srg']/div[1]");

        WebElement resultElement = this.driver.findElement(result);

        String fristfound = resultElement.getText();
        String expected = "Sentinel - PrimeFaces\nprimefaces.org/layouts/sentinel\nTraducir esta página\nSentinel Theme And Layout Powered by PrimeFaces. Beautifully Crafted Template Demo app is included showing layout and components working in harmony.";

        assertEquals("The frist result not is the expected", fristfound, expected);


    }

}
