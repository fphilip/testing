package houseware.learn.testing.selenium.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class Autocomplete extends PrimefacesShowcase {
    @FindBy(how = How.ID, using = "j_idt88:acSimple_input")
    private WebElement simple;
    @FindBy(how = How.ID, using = "j_idt88:acMinLength_input")
    private WebElement minLength;
    @FindBy(how = How.XPATH, using = "//div[@id='j_idt88:acSimple_panel']")
    private WebElement items;


    public Autocomplete(WebDriver webDriver) {
        super(webDriver);
    }

    public void simple(final String term) {
        simple.sendKeys(term);
    }

    public String simple(final int elem) {

        WebDriverWait wait = new WebDriverWait(getWebDriver(), 2);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("ui-autocomplete-item"))
        );
        return items.findElements(By.className("ui-autocomplete-item")).get(elem).getText();
    }

    public void min3(final String term) {
        minLength.sendKeys(term);
    }

}
