package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import utilities.DataSet;
import utilities.DriverSetUp;

public class DemoLoginPageTest extends DriverSetUp {

    DemoLoginPage demoLoginPage = new DemoLoginPage();

    //Sobar age run hobe....
    @BeforeMethod
    public void navigateToLoginPage(){
        getDriver().get(demoLoginPage.demoPageUrl);
    }

    @Test
    public void testLoginWithValidCredentials(){
        //getDriver().get(demoLoginPage.demoPageUrl);
        demoLoginPage.writeOnElement(demoLoginPage.demoUserName,"standard_user");
        demoLoginPage.writeOnElement(demoLoginPage.demoPassword,"secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.demoLoginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        //Assert.assertFalse(demoLoginPage.demoLoginButton, "The 'login' button should not be present after successful login.");
    }

    @Test
    public void testLoginWithOutPassword(){
       // getDriver().get(demoLoginPage.demoPageUrl);
        demoLoginPage.writeOnElement(demoLoginPage.demoUserName,"standard_user");
        demoLoginPage.clickOnElement(demoLoginPage.demoLoginButton);
        demoLoginPage.addScreenShort("After Click On the login Button WithoutPassword");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.demoError),"Epic sadface: Password is required");

    }

    @Test
    public void testLoginWithOutUserName(){
      //  getDriver().get(demoLoginPage.demoPageUrl);
        demoLoginPage.writeOnElement(demoLoginPage.demoPassword,"secret_sauce");
        demoLoginPage.clickOnElement(demoLoginPage.demoLoginButton);
        demoLoginPage.addScreenShort("After Click On the login Button Without UserName");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.demoError),"Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithOutCredentials(){
       // getDriver().get(demoLoginPage.demoPageUrl);
        demoLoginPage.writeOnElement(demoLoginPage.demoUserName," ");
        demoLoginPage.writeOnElement(demoLoginPage.demoPassword," ");
        demoLoginPage.clickOnElement(demoLoginPage.demoLoginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.demoError),"Epic sadface: Username and password do not match any user in this service");
        //Assert.assertFalse(demoLoginPage.demoLoginButton, "The 'login' button should not be present after successful login.");
    }


    //Writing test case dynamic Method......
    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)//name of dataset and path
    public void testLoginWithInvalidCredentials(String name, String password, String error_msg){
      //  getDriver().get(demoLoginPage.demoPageUrl);
        demoLoginPage.writeOnElement(demoLoginPage.demoUserName,name);
        demoLoginPage.writeOnElement(demoLoginPage.demoPassword,password);
        demoLoginPage.clickOnElement(demoLoginPage.demoLoginButton);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.demoError),error_msg);
        //Assert.assertFalse(demoLoginPage.demoLoginButton, "The 'login' button should not be present after successful login.");
    }
}
