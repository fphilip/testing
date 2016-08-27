package houseware.learn.testing.selenium.webpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PrimefacesShowcase {
    @FindBy(how = How.ID, using = "menuSearch")
    private WebElement searchMenu;

    @FindBy(how = How.ID, using = "test")
    private WebElement error;

    @Getter
    private WebDriver webDriver;

    public PrimefacesShowcase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void searchFor(final String term) {
        searchMenu.sendKeys(term);
        searchMenu.submit();
    }

    public boolean is404() {
        //// TODO:
        return false;
    }

}
