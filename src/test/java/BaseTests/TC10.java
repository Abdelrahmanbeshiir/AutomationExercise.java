package BaseTests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends SetUp{
    @Test
    public void TestRegisterWhileCheckout()
    {
        ProductsPage productsPage=homePage.ClickProductsPage();
        productsPage.AddProductToCart(2);
        productsPage.ContinueShopping();
        productsPage.AddProductToCart(5);
        CartPage cartPage=productsPage.ClickViewCart();
        cartPage.ClickProceedToCheckout();
        LoginOrSignUpPage loginOrSignUpPage=cartPage.ClickRegister_login();
        AccountInfoPage accountInfoPage=loginOrSignUpPage.SignUpWith("abdo","abdoo292@gmail.com");
        AccountCreatedPage accountCreatedPage=accountInfoPage.
                EnterDataAndClickCreatAccount("male","654645a","26","12","1996");
        UserPage userPage=accountCreatedPage.ClickContinue();
        Assert.assertEquals(userPage.GetLoggedInAS(),"Logged in as abdo");
        CartPage cartPage1=userPage.GoToCart();
        CheckOut checkOut=cartPage1.ClickProceedToCheckout();
        checkOut.EnterComment("HelloWorld");
        PaymentPage paymentPage=checkOut.ClickPlaceOrder();
        ConfirmedOrderPage confirmedOrderPage=paymentPage.EnterCardDataAndConfirm("Abdo","6546446","546","10","1995");
        Assert.assertEquals(confirmedOrderPage.GetConfirmationMsg(),"Congratulations! Your order has been confirmed!");
        userPage.DeleteAccount();







    }
}
