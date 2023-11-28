package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/** 1. create class "TopMenuTest"
 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 string
 1.2 This method should click on the menu whatever name is passed as parameter.
 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends Utility {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    public void selectMenu(String menu) {
        List<WebElement> allMenu = driver.findElements(By.xpath("//ul[@class = 'top-menu mobile']/li"));
        for (WebElement option : allMenu) {
            if (menu.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        //verify navigation of page
        selectMenu("Computers");
        Assert.assertEquals("Computers",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"),"Computers"));
        Thread.sleep(2000);
        selectMenu("Electronics");
        Assert.assertEquals("Electronics",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"),"Electronics "));
        selectMenu("Apparel");
        Assert.assertEquals("Apparel",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']"),"Apparel"));
        selectMenu("Digital downloads");
        Assert.assertEquals("Digital downloads",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']"),"Digital downloads"));
        Thread.sleep(2000);
        selectMenu("Books");
        Assert.assertEquals("Books",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']"),"Books"));
        selectMenu("Jewelry");
        Assert.assertEquals("Jewelry",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']"),"Jewelry"));
        selectMenu("Gift Cards");
        Assert.assertEquals("Gift Cards",getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']"),"Gift Cards"));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
