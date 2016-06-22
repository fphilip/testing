package houseware.learn.testing.selenium.simple;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


import static houseware.learn.testing.selenium.complex.SeleniumWait.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author fphilip@houseware.es
 */
public abstract class GoogleTest {

    public abstract WebDriver getDriver();

    @Test
    public void testGoogleSearch() throws InterruptedException {
        GoogleTest.google_search_1(getDriver());
    }

    @Test
    public void testGoogleSearchShowcase() {
        GoogleTest.google_search_showcase(getDriver());
    }


    public static void google_search_1(WebDriver driver) throws InterruptedException {

        driver.get("http://www.google.com");

        assertEquals("Google", driver.getTitle());

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium - Web Browser Automation");
        submit(element, 10);

        assertEquals("Selenium - Web Browser Automation - Buscar con Google", driver.getTitle());

        By result = By.className("g");
        List<WebElement> resultElement = driver.findElements(result);


        String fristfound = resultElement.get(0).getText();

        assertTrue("The first result not is the expected", fristfound.contains("www.seleniumhq.org"));

    }


    public static void google_search_showcase(WebDriver driver) {
        driver.get("http://www.google.com/");
        By input = By.id("lst-ib");
        WebElement inputElement = driver.findElement(input);
        inputElement.sendKeys("PrimeFaces ShowCase");

        By botton = By.cssSelector(".lsb");

        WebElement bottonElement = driver.findElement(botton);
        bottonElement.click();

        By result = By.xpath("//div[@class='srg']/div[1]");

        WebElement resultElement = driver.findElement(result);

        String fristfound = resultElement.getText();
        String expected = "Sentinel - PrimeFaces\nprimefaces.org/layouts/sentinel\nTraducir esta página\nSentinel Theme And Layout Powered by PrimeFaces. Beautifully Crafted Template Demo app is included showing layout and components working in harmony.";

        assertEquals("The frist result not is the expected", fristfound, expected);

    }
}
