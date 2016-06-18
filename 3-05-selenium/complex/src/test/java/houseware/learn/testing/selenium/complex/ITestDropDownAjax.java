package houseware.learn.testing.selenium.complex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ITestDropDownAjax extends AbstractSeleniumTest{

    @Test
    public void mmenu_deploy(){

        this.driver.get("http://www.primefaces.org/showcase/ui/ajax/dropdown.xhtml");
        By dropDown = By.id("j_idt87:country_label");
        WebElement dropDownElement = this.driver.findElement(dropDown);
        dropDownElement.click();
        By panel = By.id("j_idt87:country_panel");
        WebElement panelElement = this.driver.findElement(panel);
        assertTrue(panelElement.isDisplayed());
        dropDownElement.click();
        assertFalse(panelElement.isDisplayed());

    }

    @Test
    public void mmenu_deploy_select_usa(){

        this.driver.get("http://www.primefaces.org/showcase/ui/ajax/dropdown.xhtml");
        By dropDown = By.id("j_idt87:country_label");
        WebElement dropDownElement = this.driver.findElement(dropDown);
        dropDownElement.click();

        By optionUSA = By.xpath("//ul[@id='j_idt87:country_items']/li[2]");
        WebElement optionUSAElement = this.driver.findElement(optionUSA);
        optionUSAElement.click();

        By labelMenu = By.id("j_idt87:country_label");
        WebElement labelMenuElement = this.driver.findElement(labelMenu);

        assertEquals(labelMenuElement.getText(), "USA");
    }
}
