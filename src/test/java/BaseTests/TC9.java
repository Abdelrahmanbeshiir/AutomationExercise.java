package BaseTests;

import Pages.CartPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC9 extends SetUp{
    @Test
    public void CheckAddProductsIntoCart()
    {
        ProductsPage productsPage=homePage.ClickProductsPage();

        String price1=productsPage.GetProductPrice(1);
        productsPage.AddProductToCart(1);
        productsPage.ContinueShopping();
        productsPage.AddProductToCart(1);
        productsPage.ContinueShopping();
        String price2=productsPage.GetProductPrice(2);
        productsPage.AddProductToCart(2);
        CartPage cartPage=productsPage.ClickViewCart();
        Assert.assertEquals(cartPage.GetCartPriceForProduct(1),price1);
        Assert.assertEquals(cartPage.GetCartPriceForProduct(2),price2);
        Assert.assertEquals(cartPage.GetProductQuantity(1),2);
        Assert.assertEquals(cartPage.GetProductQuantity(2),1);
        Assert.assertEquals(cartPage.GetProductTotal(1),"Rs. 1000");
        Assert.assertEquals(cartPage.GetProductTotal(2),"Rs. 400");

    }
}
