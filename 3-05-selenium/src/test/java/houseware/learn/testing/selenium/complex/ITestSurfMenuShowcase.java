package houseware.learn.testing.selenium.complex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class ITestSurfMenuShowcase extends AbstractSeleniumTest {

    @Test
    public void click_data_menu(){

        getWebDriver().get("http://www.primefaces.org/showcase/");
        By menuData = By.id("SubMenu-Data");

        WebElement menuDataElement = getWebDriver().findElement(menuData);
        menuDataElement.click();

        By menuContainer = By.xpath("//a[@href='/showcase/ui/data/datatable/basic.xhtml']");
        WebElement menuContainerElement = getWebDriver().findElement(menuContainer);

        menuContainerElement.click();

        assertEquals(getWebDriver().getCurrentUrl(), "http://www.primefaces.org/showcase/ui/data/datatable/basic.xhtml");

    }

    @Test
    public void click_data_menu_panel_wizard(){

        getWebDriver().get("http://www.primefaces.org/showcase/");
        By menuData = By.id("SubMenu-Data");

        WebElement menuDataElement = getWebDriver().findElement(menuData);
        menuDataElement.click();

        By menuPanel = By.id("SubMenu-Panel");
        WebElement menuPanelElement = getWebDriver().findElement(menuPanel);
        menuPanelElement.click();

        By menuContainer = By.xpath("//a[@href='/showcase/ui/panel/wizard.xhtml']");
        WebElement menuContainerElement = getWebDriver().findElement(menuContainer);

        menuContainerElement.click();

        assertEquals(getWebDriver().getCurrentUrl(), "http://www.primefaces.org/showcase/ui/panel/wizard.xhtml");

    }
}
