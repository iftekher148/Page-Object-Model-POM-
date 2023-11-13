package pages;

import org.openqa.selenium.By;

public class DemoLoginPage extends BasePage{
        public String demoPageUrl = "https://www.saucedemo.com/";
        public By demoUserName = By.xpath("//input[@id='user-name']");
        public By demoPassword = By.xpath("//input[@id='password']");
        public By demoLoginButton = By.xpath("//input[@id='login-button']");
        public By demoError = By.cssSelector("h3[data-test='error']");
        public String ErrorMsg = "Epic sadface: Username is required";
    // boolean isLoginButtonPresent = (By.xpath("//input[@id='login-button']")).size() > 0;

        public void doLogin(String user_Name, String pass_word){
                writeOnElement(demoUserName,user_Name);
                writeOnElement(demoPassword,pass_word);
                clickOnElement(demoLoginButton);
        }

}
