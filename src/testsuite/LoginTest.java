package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter Valid username
        sendTextToElement(By.name("username"), "PariPatel");
        // Enter valid password
        sendTextToElement(By.name("password"), "test678");
        // Click on 'LOGIN' button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //This is from the requirement
        String expectedMessage = "The username and password could not be verified";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Error!')]"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyErrorMessage() {
        //Enter invalid username
        sendTextToElement(By.name("username"), "pp1987@gmail.com");
        //Enter invalid password
        sendTextToElement(By.name("password"), "12356");
        //Click on login button
        clickOnElement(By.xpath("//input[@class='button']"));
        // Verify the error message 'The username and password could not be verified'.
        // verifyExpectedAndActual(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"),"The username and password could not be verified.");

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Enter Valid username
        sendTextToElement(By.name("username"), "PariPatel");
        // Enter valid password
        sendTextToElement(By.name("password"), "test678");
        // Click on 'LOGIN' button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //Click on logout button
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //verify the text"Customer Login"
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Customer Login')]"), "Customer Login");
    }

    public void closeBrowser() {
        driver.quit();
    }
}
