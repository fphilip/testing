package houseware.learn.testing.phatomjs;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class ITestGoogleSearchPantomDriver extends AbstractPantomDriverTest {

    @Test
    public void google_search_selenium() throws InterruptedException {

        driver.get("http://www.google.com");

        assertEquals("Google", this.driver.getTitle());

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium - Web Browser Automation");
        element.submit();

        assertEquals("Selenium - Web Browser Automation - Buscar con Google", this.driver.getTitle());

        By result = By.className("g");
        List<WebElement> resultElement = this.driver.findElements(result);


        String fristfound = resultElement.get(0).getText();
        String expected = "Selenium - Web Browser Automation\nwww.seleniumhq.org/\nSite of web browser automation tool with .NET provider and related\ndocumentation.\nDownloads - Documentation - Selenium WebDriver - Selenium IDE";

        assertEquals("The frist result not is the expected", fristfound, expected);

    }

    @Test
    public void google_search_showcase(){
        this.driver.get("http://www.google.com/");

        assertEquals("Google", this.driver.getTitle());

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("PrimeFaces ShowCase");
        element.submit();

        By result = By.className("g");
        List<WebElement> resultElement = this.driver.findElements(result);

        String fristfound = resultElement.get(0).getText();
        String expected = "PrimeFaces ShowCase\nwww.primefaces.org/showcase/\nReady For PrimeTime PrimeFaces is a popular open source framework for\nJavaServer Faces featuring over 100 components, touch optimized mobilekit,\npush ...\nDataTable\nSelection - Edit - Filter - ...\nCarousel\nCarousel Carousel displays data using a slide effect. Since v5.2.8 ...\nDataGrid\nDataGrid DataGrid displays data in a grid layout. Responsive mode ...\nOneRadio\nSelectOneRadio SelectOneRadio is used to choose a single item ...\nDialog\nOverlayPanel - Login - Dynamic - ...\nGrowl\nGrowl Growl displays messages in an ... p:growl id = \"growl ...\nMás resultados de primefaces.org »";

        assertEquals("The frist result not is the expected", fristfound, expected);

    }



}
