package houseware.learn.testing.selenium.webpage;

import houseware.learn.testing.AbstractSeleniumTest;
import houseware.learn.testing.ChromeTestUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TestPageObjects extends AbstractSeleniumTest {



    @Override
    public WebDriver buildDriver() {
        return ChromeTestUtils.newDriver();
    }

    public String getHost() {
        return "http://www.primefaces.org/showcase";
    }

    @Test
    public void menu_search() {
        open("/");
        getWebDriver().manage().window().maximize();
        PrimefacesShowcase homePage = PageFactory.initElements(getWebDriver(),
                PrimefacesShowcase.class);
        homePage.searchFor("ajax");
        PrimefacesMenuList resultsPage = PageFactory.initElements(getWebDriver(), PrimefacesMenuList.class);
        assertTrue(resultsPage
                .containsSearchResult("Ajax Core"));
    }

    @Test
    public void autocomplete() {
        open("/ui/input/autoComplete.xhtml");
        Autocomplete autocomplete = PageFactory.initElements(getWebDriver(), Autocomplete.class);
        autocomplete.simple("aj");
        Assert.assertEquals("aj1", autocomplete.simple(1));
    }
}
