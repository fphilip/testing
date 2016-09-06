package houseware.learn.testing.selenium.complex;

import houseware.learn.testing.ITestShowcase;
import houseware.learn.testing.FirefoxTestUtils;
import org.openqa.selenium.WebDriver;

/**
 * @author fphilip@houseware.es
 */
public class ITestShowcaseFirefox extends ITestShowcase {

    @Override
    public WebDriver buildDriver() {
        return FirefoxTestUtils.newDriver();
    }


}
