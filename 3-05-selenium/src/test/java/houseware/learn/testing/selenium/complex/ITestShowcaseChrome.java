package houseware.learn.testing.selenium.complex;

import houseware.learn.testing.ITestShowcase;
import houseware.learn.testing.ChromeTestUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */
public class ITestShowcaseChrome extends ITestShowcase {


    public WebDriver buildDriver() {
        return ChromeTestUtils.newDriver();
    }



}
