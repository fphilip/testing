package houseware.learn.testing.selenium.complex;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class ITestCanvas extends AbstractSeleniumTest {

    @Test
    public void click_on_canvas_simple_pie(){

        this.driver.get("http://www.primefaces.org/showcase/ui/chart/interactive.xhtml");

        By canvas = By.xpath("//div[@id='j_idt88:j_idt90']/canvas[@class='jqplot-event-canvas']");
        WebElement canvasElement = this.driver.findElement(canvas);

        Actions actionBuilder=new Actions(driver);
        Action drawOnCanvas=actionBuilder
                .moveToElement(canvasElement,8,8)
                .clickAndHold(canvasElement)
                .release(canvasElement)
                .build();
        drawOnCanvas.perform();

        By growlMessage = By.xpath("//div[@id='j_idt88:growl_container']/div/div[@class='ui-growl-item']/div[@class='ui-growl-message']/p");
        WebElement growlMessageElement = this.driver.findElement(growlMessage);

        String growlPMessage = growlMessageElement.getText();

        assertEquals(growlPMessage, "Item Index: 2, Series Index:0");
    }

}
