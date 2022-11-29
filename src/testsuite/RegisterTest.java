package testsuite;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // Click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //This is from requirement
        String expectedMessage = "Signing up is easy!";

        // Find the Register text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));

        // Validate actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // Click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // Enter First name
        sendTextToElement(By.id("customer.firstName"), "Pari");
        // Enter Last name
        sendTextToElement(By.id("customer.lastName"), "Patel");
        // Enter Address
        sendTextToElement(By.id("customer.address.street"), "CB4 3NB");
        //Enter City
        sendTextToElement(By.id("customer.address.city"), "Cambridge");
        //Enter State
        sendTextToElement(By.id("customer.address.state"), "Cambridgeshire");
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "CB4 3NB");
        //Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "+44 09876545677");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"), "6777");
        //Enter Username
        sendTextToElement(By.id("customer.username"), "PariPatel");
        //Enter Password
        sendTextToElement(By.id("customer.password"), "122334");
        //Enter Confirms
        sendTextToElement(By.id("repeatedPassword"), "122334");
        //Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //This is from requirement
        String expectedMessage = "Your account was created successfully.You are now logged in.'";
        // Find the Register text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
