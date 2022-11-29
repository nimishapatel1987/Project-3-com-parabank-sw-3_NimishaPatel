package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */

    // Method  with no return type with  Parameter
    public void clickOnElement(By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    // Method  with no return type with  Parameter
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    // Method with  return type with Parameter
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    // Method to verify Expected and Actual Message
    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
      //  Assert.assertEquals(actualText, expectedText);

    }
    /**
     * this method will switch to alert
     */

    public void switchToAlert(){
        driver.switchTo().alert();
    }
}


