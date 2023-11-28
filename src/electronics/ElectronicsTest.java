package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * ● Create package Electronics
 * 1. Create the class ElectronicsTest
 * Write the following test
 */
public class ElectronicsTest extends Utility {

    String baseURL = "https://demo.nopcommerce.com/";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3 Verify the text “Cell phones”
        Assert.assertEquals("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones"));
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.linkText("Nokia Lumia 1020"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("Nokia Lumia 1020", getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020"));
        //2.7 Verify the price “$349.00”
        Assert.assertEquals("$349.00", getTextFromElement(By.xpath("//span[@id='price-value-20']"), "$349.00"));
        //2.8 Change quantity to 2
        clearText(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"), "The product has been added to your shopping cart");
        Assert.assertEquals(expectedMsg,actualMsg);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals("shopping cart", getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]"), "shopping cart"));
        //2.13 Verify the quantity is 2
        Assert.assertEquals("2", getTextFromElement(By.xpath("//input[@id='itemquantity11255']"), "2"));
        //2.14 Verify the Total $698.00
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']"), "$698.00"));
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("$349.00", getTextFromElement(By.xpath("//span[@id='price-value-20']"), "$349.00"));
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        //2.19 Verify the text “Register”
        Assert.assertEquals("Register", getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"), "Register"));
        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male'])"));
        sendTextToElement(By.id("FirstName"),"Prime");
        sendTextToElement(By.id("LastName"),"Testing");
        sendTextToElement(By.xpath("//input[@id='Email']"),"Prim123@gmail.com");
        sendTextToElement(By.name("Password"),"Prime123");
        sendTextToElement(By.name("ConfirmPassword"),"Prime123");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        String expectedMsg1 = "Your registration completed";
        String actualMsg1 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        Assert.assertEquals(expectedMsg1,actualMsg1);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 Verify the text “Shopping card”
        Assert.assertEquals("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart"));
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Prime123@gmail.com");
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        sendTextToElement(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "202,Watkins Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "AB1CD2");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "4545676789");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        selectByVisibleTextFromDropdown(By.xpath("//option[contains(text(),'Visa')]"),"Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Prime");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4111111111111111");
        indexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),10);
        indexFromDropDown(By.xpath("//select[@id='ExpireYear']"),2036);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"321");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedText1 = "Payment Method: Credit Card";
        String actualText1 = getTextFromElement(By.xpath("//span[contains(text(),'Payment Method:')]"),"Payment Method: Credit Card");
        Assert.assertEquals(expectedText1,actualText1);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedMethod = "Shipping Method: 2nd Day Air";
        String actualMethod = getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]"),"Shipping Method: 2nd Day Air");
        Assert.assertEquals(expectedMethod,actualMethod);
        //2.37 Verify Total is “$698.00”
        Assert.assertEquals("$698.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"), "$698.00"));
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.39 Verify the Text “Thank You”
        Assert.assertEquals("Thank You", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"), "Thank You"));
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMsg2 = "Your order has been successfully processed!";
        String actualMsg2 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),"Your order has been successfully processed!");
        Assert.assertEquals(expectedMsg2,actualMsg2);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        String expectedMsg3 = "Welcome to our store";
        String actualMsg3 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
        Assert.assertEquals(expectedMsg3,actualMsg3);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/
        String expectedURL = "https://demo.nopcommerce.com";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("Wrong URL",expectedURL,actualURL);


    }

    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
