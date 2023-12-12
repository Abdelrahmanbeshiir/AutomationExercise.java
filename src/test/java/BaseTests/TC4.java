package BaseTests;

import Pages.AccountCreatedPage;
import Pages.LoginOrSignUpPage;
import Pages.UserPage;
import Resources.SignUpData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4 extends SetUp{

    @Test(dataProviderClass= SignUpData.class,dataProvider = ("SignUpData(name,gender,email,password,day,month,year)"))
    public void TestLogoutUser(String name,String gender,String email,String password,String day,String month,String year)
    {
        Assert.assertTrue(homePage.IsHomePageDisplayed(),"home page not displayed");
        AccountCreatedPage accountCreatedPage=homePage.Register(name,gender,email,password,day,month,year);
        UserPage userPage=accountCreatedPage.ClickContinue();
        Assert.assertTrue(userPage.GetLoggedInAS().contains("Logged in as "+name),"Logged in Failed");
        LoginOrSignUpPage loginOrSignUpPage=userPage.LogOut();
        Assert.assertTrue(loginOrSignUpPage.IsSignupVisible());
        loginOrSignUpPage.LoginWith(email,password).DeleteAccount();
    }
}
