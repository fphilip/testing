package houseware.learn.testing.selenium.complex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {

    public static void waitModalFinish(WebDriver driver, By modal, int timeout){
        WebElement modalElement = driver.findElement(modal);
        if(modalElement.isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
        }
    }


    public static void submit(WebElement element, long milli){
        element.submit();
        sleep(milli);
    }


    public static void sleep(long milli){
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
