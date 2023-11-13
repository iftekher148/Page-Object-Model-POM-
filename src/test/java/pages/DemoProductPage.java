package pages;

import org.openqa.selenium.By;

public class DemoProductPage extends BasePage{
     public By AddToCart_Button = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
     public By CartItemCount = By.xpath("//span[@class='shopping_cart_badge']");
     public By removeItem = By.xpath("//button[@id='remove-sauce-labs-backpack']");

     public String getCurrentCartItemCount(){
          return getElementText(CartItemCount);
     }

}
