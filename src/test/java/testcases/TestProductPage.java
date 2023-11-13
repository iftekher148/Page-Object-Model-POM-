package testcases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import pages.DemoProductPage;
import utilities.DriverSetUp;

public class TestProductPage extends DriverSetUp {

    DemoLoginPage demoLoginPage = new DemoLoginPage();
    DemoProductPage demoProductPage = new DemoProductPage();



    //You can write this method on DemoProduct page and call it here...
    @BeforeMethod
    public void navigateToProductPage(){
        getDriver().get(demoLoginPage.demoPageUrl);
        demoLoginPage.doLogin("standard_user","secret_sauce");
    }

    @Test
    public void testAddToCartButton(){
        demoProductPage.clickOnElement(demoProductPage.AddToCart_Button);
        Assert.assertEquals(demoProductPage.getCurrentCartItemCount(),"1");
    }

    @Test(description = "Description for Remove Cart Button. It's from selenium")
    @Description("Allure Description: It comes from Allure")
    public void testRemoveToCartButton(){
        //demoProductPage.clickOnElement(demoProductPage.AddToCart_Button);

        demoProductPage.clickOnElement(demoProductPage.removeItem);
        Assert.assertTrue(demoProductPage.isElementVisible(demoProductPage.AddToCart_Button));
        Assert.assertFalse(demoProductPage.isElementVisible(demoProductPage.removeItem));

    }
}
