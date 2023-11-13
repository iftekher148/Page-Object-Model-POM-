package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

    public String homepageURL = "https://demo.nopcommerce.com/";
    public String homePageTitle = "nopCommerce demo store";
    public By registration_button = By.xpath("//a[normalize-space()='Register']");
    public By login_button = By.xpath("//a[normalize-space()='Log in']");

}
