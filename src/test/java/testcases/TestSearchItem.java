package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProduct;
import utilities.DriverSetUp;

public class TestSearchItem extends DriverSetUp {

    SearchProduct searchProduct = new SearchProduct();
    @Test
    public void testSearchPage(){
        getDriver().get(searchProduct.searchUrl);
       searchProduct.writeOnElement(searchProduct.searchText,"Apple MacBook Pro 13-inch");
       searchProduct.clickOnElement(searchProduct.searchButton);
       searchProduct.clickOnElement(searchProduct.addToCart);
       searchProduct.clickOnElement(searchProduct.addToCartSecond);
       searchProduct.clickOnElement(searchProduct.shippingCart);

        Assert.assertEquals(searchProduct.getElementText(searchProduct.totalUnitPrice),"$1,800.00");
        Assert.assertEquals(searchProduct.getElementText(searchProduct.totalActualPrice),"$3,600.00");
    }

}
