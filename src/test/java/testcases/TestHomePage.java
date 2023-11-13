package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.DriverSetUp;

//Test Cases DriverSetUp Extend korbe
//Pages BaseClass Extend korbe

public class TestHomePage extends DriverSetUp {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void testHomePageTitle(){
        getDriver().get(homePage.homepageURL);
        String title=  getDriver().getTitle();
        Assert.assertEquals(title,homePage.homePageTitle);
    }

    @Test
    public void testHomePageUrl(){
        getDriver().get(homePage.homepageURL);
        //String title=  getDriver().getTitle();
        Assert.assertEquals(getDriver().getCurrentUrl(),homePage.homepageURL);
    }

    @Test
    public void testHomePageRegistrationButton(){
        getDriver().get(homePage.homepageURL);
       // homePage.getElement(homePage.registration_button).click();// Without writing Click Method
        homePage.clickOnElement(homePage.registration_button);
        //Assert.assertTrue(homePage.getElement(homePage.registration_button).isDisplayed()); //Without Writing a Method
        Assert.assertTrue(homePage.isElementVisible(homePage.registration_button));
        Assert.assertEquals(getDriver().getCurrentUrl(),registrationPage.registrationUrl);
    }

    @Test
    public void testHomePageLoginButton(){
        getDriver().get(homePage.homepageURL);
        // homePage.getElement(homePage.registration_button).click();// Without writting Click Method
        homePage.clickOnElement(homePage.login_button);
        Assert.assertTrue(homePage.isElementVisible(homePage.login_button));
        Assert.assertEquals(getDriver().getCurrentUrl(),loginPage.loginURL);
    }

}
