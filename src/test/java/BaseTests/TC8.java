package BaseTests;

import Pages.ProductsPage;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC8 extends SetUp{
    @Test
    public void TestSearchForProduct()
    {
        String product="Sleeves Top";
        ProductsPage productsPage=homePage.ClickProductsPage();
        productsPage.SearchForProduct(product);
        Assert.assertTrue(productsPage.CheckSearchResultsRelatedTo(product));
    }
}
