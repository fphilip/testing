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
