package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create the package name computer
 * 1. Create class “TestSuite”
 */
public class TestSuite extends Utility {
    String baseURL = "https://demo.nopcommerce.com/";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        // 1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[normalize-space()='Computers'][1]"));
        Thread.sleep(2000);
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        Thread.sleep(2000);
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        Thread.sleep(2000);
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        String expectedResult = "Name: Z to A";
        String actualResult = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"), "Name: Z to A");
        Assert.assertEquals("Error", expectedResult, actualResult);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[normalize-space()='Computers'][1]"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        mouseHoverToElementAndClick(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals("Build your own computer", getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.xpath("//select[@id='product_attribute_1']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        clickOnElement(By.xpath("//select[@id='product_attribute_2']"));
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        mouseHoverToElementAndClick(By.xpath("//label[contains(text(),'Vista Premium [+$60.00]"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        selectCheckBox(By.xpath("//input[@id='product_attribute_5_10']"));
        selectCheckBox(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        Assert.assertEquals("Price does not match", "$1,475.00", getTextFromElement(By.xpath("//span[@id='price-value-1']"), "$1,475.00"));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='bar-notification success']"), "The product has been added to your shopping cart");
        Assert.assertEquals(expectedMessage, actualMessage);

        //After that close the bar clicking on the cross button.
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.15 Verify the message "Shopping cart"
        String expectedText = "Shopping cart";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        Assert.assertEquals(expectedText, actualText);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearText(By.xpath("//input[@id='itemquantity11267']"));
        sendTextToElement(By.xpath("//input[@id='itemquantity11267']"), "2");
        //2.17 Verify the Total"$2,950.00"
        String expectedNum = "$2,950.00";
        String actualNum = getTextFromElement(By.xpath("//span[@class='value-summary']//strong"), "$2,950.00");
        Assert.assertEquals(expectedNum, actualNum);
        //2.18 click on checkbox “I agree with the terms of service”
        mouseHoverToElementAndClick(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!
        String expectedNote = "“Welcome, Please Sign In!";
        String actualNote = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "“Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Testing");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "Prime123@gmail.com");
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        sendTextToElement(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "202,Watkins Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "AB1CD2");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "4545676789");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        selectByVisibleTextFromDropdown(By.xpath("//option[@value='MasterCard']"),"MasterCard");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Prime");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5105105105105100");
        indexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),5);
        indexFromDropDown(By.xpath("//select[@id='ExpireYear']"),2026);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"454");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedText1 = "Payment Method: Credit Card";
        String actualText1 = getTextFromElement(By.xpath("//span[contains(text(),'Payment Method:')]"),"Payment Method: Credit Card");
        Assert.assertEquals(expectedText1,actualText1);
        //2.32 Verify “Shipping Method” is “Next Day Air"
        String expectedMethod = "Shipping Method: Next Day Air";
        String actualMethod = getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]"),"Shipping Method: Next Day Air");
        Assert.assertEquals(expectedMethod,actualMethod);
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals("Total does not match","$2,950.00",getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"$2,950.00"));
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.35 Verify the Text “Thank You”
        String expectedText2= "Thank You";
        String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank You");
            Assert.assertEquals(expectedText2,actualText2);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedMsg= "Your order has been successfully processed!";
        String actualMsg= getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        Assert.assertEquals(expectedMsg,actualMsg);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        String expectedMsg1= "Welcome to our store";
        String actualMsg1= getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
        Assert.assertEquals(expectedMsg1,actualMsg1);


    }

    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
