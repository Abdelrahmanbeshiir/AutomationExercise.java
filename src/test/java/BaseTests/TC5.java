package BaseTests;

import Pages.AccountCreatedPage;
import Pages.LoginOrSignUpPage;
import Pages.UserPage;
import Resources.SignUpData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC5 extends SetUp {
    @Test(dataProviderClass= SignUpData.class,dataProvider = ("SignUpData(name,gender,email,password,day,month,year)"))
    public void RegisterUserWithExistingEmail(String name,String gender,String email,String password,String day,String month,String year)

    {
        AccountCreatedPage accountCreatedPage=homePage.Register(name,gender,email,password,day,month,year);
        UserPage userPage =accountCreatedPage.ClickContinue();
        LoginOrSignUpPage loginOrSignUpPage1=userPage.LogOut();
        Assert.assertTrue(loginOrSignUpPage1.IsSignupVisible());
        loginOrSignUpPage1.SignupWithAlreadyExist(name,email);
        Assert.assertTrue(loginOrSignUpPage1.IsEmailExist());
        System.out.println("Checked");
        loginOrSignUpPage1.LoginWith(email, password).DeleteAccount();


    }
}
