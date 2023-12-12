package BaseTests;

import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7 extends SetUp{
    @Test
    public void TestProductDetailsPage()
    {
        ProductsPage productsPage=homePage.ClickProductsPage();

        Assert.assertEquals(productsPage.GetProductPageTitle(),"ALL PRODUCTS");
        Assert.assertTrue(productsPage.ClickOnProduct().VerfiyProductDetail());

    }
}
