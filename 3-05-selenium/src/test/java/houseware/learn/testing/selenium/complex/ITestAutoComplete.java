package houseware.learn.testing.selenium.complex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class ITestAutoComplete extends AbstractSeleniumTest {

    @Test
    public void autocomplete_input(){

        getWebDriver().get("http://www.primefaces.org/showcase/ui/input/autoComplete.xhtml");
        By input = By.id("j_idt88:acSimple_input");
        WebElement inputElement = getWebDriver().findElement(input);
        inputElement.sendKeys("Selenium");

        By autocompleteSelect = By.xpath("//div[@id='j_idt88:acSimple_panel']/ul/li[4]");
        WebElement autocompleteElement = getWebDriver().findElement(autocompleteSelect);
        autocompleteElement.click();

        By submit = By.id("j_idt88:j_idt117");
        WebElement submitElement = getWebDriver().findElement(submit);
        submitElement.click();

        SeleniumWait.waitModalFinish(getWebDriver(), By.id("j_idt159_start"), 2);

        assertEquals(getWebDriver().findElement(By.xpath("//table[@id='j_idt88:output']/tbody/tr[1]/td[2]")).getText(), "Selenium3");
    }

}
