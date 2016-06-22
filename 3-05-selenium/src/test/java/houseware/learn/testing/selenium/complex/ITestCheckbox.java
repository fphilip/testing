package houseware.learn.testing.selenium.complex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class ITestCheckbox extends AbstractSeleniumTest {

    @Test
    public void boolean_checkbox(){

        this.driver.get("http://www.primefaces.org/showcase/ui/input/booleanCheckbox.xhtml");
        By checkAjax = By.xpath("//div[@id='j_idt87:j_idt92']/div[2]");

        WebElement checkAjaxElement = this.driver.findElement(checkAjax);
        checkAjaxElement.click();

        SeleniumWait.waitModalFinish(this.driver, By.id("j_idt106_start"), 2);

        By bottonSubmit = By.id("j_idt87:j_idt93");
        WebElement submit = this.driver.findElement(bottonSubmit);
        submit.click();

        By dialogModal = By.id("j_idt87:j_idt94_modal");
        WebElement dialogModalElement = this.driver.findElement(dialogModal);

        assertTrue(dialogModalElement.isDisplayed());

        By tableValueOne = By.xpath("//table[@id='j_idt87:display']/tbody/tr[1]/td");
        WebElement tableValueOneElement = this.driver.findElement(tableValueOne);

        assertEquals(tableValueOneElement.getText(), "Value 1: false");

        By tableValueTwo = By.xpath("//table[@id='j_idt87:display']/tbody/tr[2]/td");
        WebElement tableValueTwoElement = this.driver.findElement(tableValueTwo);

        assertEquals(tableValueTwoElement.getText(), "Value 2: true");

    }

    @Test
    public void boolean_checkbox_menu(){

        this.driver.get("http://www.primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        By menu = By.cssSelector(".ui-selectcheckboxmenu-trigger");

        WebElement menuElement = this.driver.findElement(menu);
        menuElement.click();

        By selectMenu = By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']/ul/li[6]");
        WebElement select = this.driver.findElement(selectMenu);
        select.click();

        menuElement.click();

        By submit = By.id("j_idt87:j_idt91");
        WebElement submitElement = this.driver.findElement(submit);
        submitElement.click();

        SeleniumWait.waitModalFinish(this.driver, By.id("j_idt103_start"), 2);

        By label = By.xpath("//ul[@id='j_idt87:j_idt92_list']/li[1]");
        WebElement labelElement = this.driver.findElement(label);

        assertEquals(labelElement.getText(), "Barcelona");
    }

    @Test
    public void boolean_checkbox_menu_multiple(){

        this.driver.get("http://www.primefaces.org/showcase/ui/input/checkboxMenu.xhtml");
        By menu = By.cssSelector(".ui-selectcheckboxmenu-trigger");

        WebElement menuElement = this.driver.findElement(menu);
        menuElement.click();

        By selectBarcelona = By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']/ul/li[6]");
        WebElement selectBarcelonaElement = this.driver.findElement(selectBarcelona);
        selectBarcelonaElement.click();

        By selectAmsterdam= By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']/ul/li[9]");
        WebElement selectAmsterdamElement = this.driver.findElement(selectAmsterdam);
        selectAmsterdamElement.click();

        menuElement.click();

        By submit = By.id("j_idt87:j_idt91");
        WebElement submitElement = this.driver.findElement(submit);
        submitElement.click();

        SeleniumWait.waitModalFinish(this.driver, By.id("j_idt103_start"), 2);

        By labelBarcelona = By.xpath("//ul[@id='j_idt87:j_idt92_list']/li[1]");
        WebElement labelBarcelonaElement = this.driver.findElement(labelBarcelona);

        assertEquals(labelBarcelonaElement.getText(), "Barcelona");

        By labelAmsterdam = By.xpath("//ul[@id='j_idt87:j_idt92_list']/li[2]");
        WebElement labelAmsterdamElement = this.driver.findElement(labelAmsterdam);

        assertEquals(labelAmsterdamElement.getText(), "Amsterdam");
    }
}
