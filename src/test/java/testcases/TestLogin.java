package testcases;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverSetUp;

public class TestLogin extends DriverSetUp {
    LoginPage loginPage = new LoginPage();
    @Test
    public void testUserLogin(){
        getDriver().get(loginPage.loginURL);
        loginPage.userLogin();

    }
}
