package houseware.learn.testing.selenium.complex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ITestDropDownAjax extends AbstractSeleniumTest{

    @Test
    public void menu_deploy(){

        getWebDriver().get("http://www.primefaces.org/showcase/ui/ajax/dropdown.xhtml");
        By dropDown = By.id("j_idt87:country_label");
        WebElement dropDownElement = getWebDriver().findElement(dropDown);
        dropDownElement.click();
        By panel = By.id("j_idt87:country_panel");
        WebElement panelElement = getWebDriver().findElement(panel);
        assertTrue(panelElement.isDisplayed());
        dropDownElement.click();
        assertFalse(panelElement.isDisplayed());

    }

    @Test
    public void menu_deploy_select_usa(){

        getWebDriver().get("http://www.primefaces.org/showcase/ui/ajax/dropdown.xhtml");
        By dropDown = By.id("j_idt87:country_label");
        WebElement dropDownElement = getWebDriver().findElement(dropDown);
        dropDownElement.click();

        By optionUSA = By.xpath("//ul[@id='j_idt87:country_items']/li[2]");
        WebElement optionUSAElement = getWebDriver().findElement(optionUSA);
        optionUSAElement.click();

        By labelMenu = By.id("j_idt87:country_label");
        WebElement labelMenuElement = getWebDriver().findElement(labelMenu);

        assertEquals(labelMenuElement.getText(), "USA");
    }
}
