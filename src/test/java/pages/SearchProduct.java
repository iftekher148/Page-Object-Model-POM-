package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import javax.swing.plaf.PanelUI;

public class SearchProduct extends BasePage{

    public String searchUrl = "https://demo.nopcommerce.com/";
    public By searchText = By.xpath("//input[@id='small-searchterms']");
    public By searchButton = By.xpath("//button[normalize-space()='Search']");
    public By addToCart = By.xpath("//button[normalize-space()='Add to cart']");
    public By addToCartSecond = By.xpath("//button[@id='add-to-cart-button-4']");
    public By shippingCart = By.xpath("//a[normalize-space()='shopping cart']");
    public By  totalUnitPrice = By.xpath("//tr/td[5]/preceding-sibling::td[1]");
    public By  totalActualPrice =By.xpath("//tr/td[5]/following-sibling::td[1]");

    //Test Case
//            Assert.assertEquals(totalUnitPrice, "$1,800.00");
//            Assert.assertEquals(totalActualPrice,"$3,600.00");



}
