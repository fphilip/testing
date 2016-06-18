package houseware.learn.testing.selenium.complex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class ITestAutoComplete extends AbstractSeleniumTest {

    @Test
    public void autocomplete_input(){

        this.driver.get("http://www.primefaces.org/showcase/ui/input/autoComplete.xhtml");
        By input = By.id("j_idt88:acSimple_input");
        WebElement inputElement = this.driver.findElement(input);
        inputElement.sendKeys("Selenium");

        By autocompleteSelect = By.xpath("//div[@id='j_idt88:acSimple_panel']/ul/li[4]");
        WebElement autocompleteElement = this.driver.findElement(autocompleteSelect);
        autocompleteElement.click();

        By submit = By.id("j_idt88:j_idt117");
        WebElement submitElement = this.driver.findElement(submit);
        submitElement.click();

        SeleniumWait.waitModalFinish(this.driver, By.id("j_idt159_start"), 2);

        assertEquals(this.driver.findElement(By.xpath("//table[@id='j_idt88:output']/tbody/tr[1]/td[2]")).getText(), "Selenium3");
    }

}
