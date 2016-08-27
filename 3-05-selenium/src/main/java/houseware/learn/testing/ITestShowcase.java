package houseware.learn.testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

/**
 * @author fphilip@houseware.es
 */
public abstract class ITestShowcase extends AbstractSeleniumTest {


    public String getHost() {
        return "http://www.primefaces.org/showcase";
    }

    @Test
    public void autocomplete_input() {

        open("/ui/input/autoComplete.xhtml");
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

        Assert.assertEquals(getWebDriver().findElement(By.xpath("//table[@id='j_idt88:output']/tbody/tr[1]/td[2]")).getText(), "Selenium3");
    }

    @Test
    public void menu_deploy() {

        open("/ui/ajax/dropdown.xhtml");
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
    public void menu_deploy_select_usa() {

        open("/ui/ajax/dropdown.xhtml");
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

    @Test
    public void click_on_canvas_simple_pie() {

        open("/ui/chart/interactive.xhtml");

        By canvas = By.xpath("//div[@id='j_idt88:j_idt90']/canvas[@class='jqplot-event-canvas']");
        WebElement canvasElement = getWebDriver().findElement(canvas);

        Actions actionBuilder = new Actions(getWebDriver());
        Action drawOnCanvas = actionBuilder
                .moveToElement(canvasElement, 8, 8)
                .clickAndHold(canvasElement)
                .release(canvasElement)
                .build();
        drawOnCanvas.perform();

        By growlMessage = By.xpath("//div[@id='j_idt88:growl_container']/div/div[@class='ui-growl-item']/div[@class='ui-growl-message']/p");
        WebElement growlMessageElement = getWebDriver().findElement(growlMessage);

        String growlPMessage = growlMessageElement.getText();

        assertEquals(growlPMessage, "Item Index: 2, Series Index:0");
    }

    @Test
    public void click_data_menu() {

        open("/");
        By menuData = By.id("SubMenu-Data");

        WebElement menuDataElement = getWebDriver().findElement(menuData);
        menuDataElement.click();

        By menuContainer = By.xpath("//a[@href='/showcase/ui/data/datatable/basic.xhtml']");
        WebElement menuContainerElement = getWebDriver().findElement(menuContainer);

        menuContainerElement.click();

        Assert.assertEquals(getWebDriver().getCurrentUrl(), "http://www.primefaces.org/showcase/ui/data/datatable/basic.xhtml");

    }

    @Test
    public void click_data_menu_panel_wizard() {

        open("/");
        By menuData = By.id("SubMenu-Data");

        WebElement menuDataElement = getWebDriver().findElement(menuData);
        menuDataElement.click();

        By menuSearch = By.id("menuSearch");
        WebElement menuSearchElement = getWebDriver().findElement(menuSearch);
        menuSearchElement.sendKeys("wiz");
        menuSearchElement.click();


        By menuPanel = By.id("SubMenu-Panel");  //todo first
        WebElement menuPanelElement = getWebDriver().findElement(menuPanel);
        menuPanelElement.click();

        By menuContainer = By.xpath("//a[@href='/showcase/ui/panel/wizard.xhtml']");
        WebElement menuContainerElement = getWebDriver().findElement(menuContainer);

        menuContainerElement.click();

        Assert.assertEquals(getWebDriver().getCurrentUrl(), "http://www.primefaces.org/showcase/ui/panel/wizard.xhtml");

    }

    @Test
    public void boolean_checkbox() {

        open("/ui/input/booleanCheckbox.xhtml");
        By checkAjax = By.xpath("//div[@id='j_idt87:j_idt92']/div[2]");

        WebElement checkAjaxElement = getWebDriver().findElement(checkAjax);
        checkAjaxElement.click();

        SeleniumWait.waitModalFinish(getWebDriver(), By.id("j_idt106_start"), 2);

        By bottonSubmit = By.id("j_idt87:j_idt93");
        WebElement submit = getWebDriver().findElement(bottonSubmit);
        submit.click();

        By dialogModal = By.id("j_idt87:j_idt94_modal");
        WebElement dialogModalElement = getWebDriver().findElement(dialogModal);

        assertTrue(dialogModalElement.isDisplayed());

        By tableValueOne = By.xpath("//table[@id='j_idt87:display']/tbody/tr[1]/td");
        WebElement tableValueOneElement = getWebDriver().findElement(tableValueOne);

        assertEquals(tableValueOneElement.getText(), "Value 1: false");

        By tableValueTwo = By.xpath("//table[@id='j_idt87:display']/tbody/tr[2]/td");
        WebElement tableValueTwoElement = getWebDriver().findElement(tableValueTwo);

        assertEquals(tableValueTwoElement.getText(), "Value 2: true");

    }

    @Test
    public void boolean_checkbox_menu() {

        open("/ui/input/checkboxMenu.xhtml");
        By menu = By.cssSelector(".ui-selectcheckboxmenu-trigger");

        WebElement menuElement = getWebDriver().findElement(menu);
        menuElement.click();

        By selectMenu = By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']/ul/li[6]");
        WebElement select = getWebDriver().findElement(selectMenu);
        select.click();

        menuElement.click();

        By submit = By.id("j_idt87:j_idt91");
        WebElement submitElement = getWebDriver().findElement(submit);
        submitElement.click();

        SeleniumWait.waitModalFinish(getWebDriver(), By.id("j_idt103_start"), 2);

        By label = By.xpath("//ul[@id='j_idt87:j_idt92_list']/li[1]");
        WebElement labelElement = getWebDriver().findElement(label);

        assertEquals(labelElement.getText(), "Barcelona");
    }

    @Test
    public void boolean_checkbox_menu_multiple() {

        open("/ui/input/checkboxMenu.xhtml");
        By menu = By.cssSelector(".ui-selectcheckboxmenu-trigger");

        WebElement menuElement = getWebDriver().findElement(menu);
        menuElement.click();

        By selectBarcelona = By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']/ul/li[6]");
        WebElement selectBarcelonaElement = getWebDriver().findElement(selectBarcelona);
        selectBarcelonaElement.click();

        By selectAmsterdam = By.xpath("//div[@class='ui-selectcheckboxmenu-items-wrapper']/ul/li[9]");
        WebElement selectAmsterdamElement = getWebDriver().findElement(selectAmsterdam);
        selectAmsterdamElement.click();

        menuElement.click();

        By submit = By.id("j_idt87:j_idt91");
        WebElement submitElement = getWebDriver().findElement(submit);
        submitElement.click();

        SeleniumWait.waitModalFinish(getWebDriver(), By.id("j_idt103_start"), 2);

        By labelBarcelona = By.xpath("//ul[@id='j_idt87:j_idt92_list']/li[1]");
        WebElement labelBarcelonaElement = getWebDriver().findElement(labelBarcelona);

        assertEquals(labelBarcelonaElement.getText(), "Barcelona");

        By labelAmsterdam = By.xpath("//ul[@id='j_idt87:j_idt92_list']/li[2]");
        WebElement labelAmsterdamElement = getWebDriver().findElement(labelAmsterdam);

        assertEquals(labelAmsterdamElement.getText(), "Amsterdam");
    }
}
