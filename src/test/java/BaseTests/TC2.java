package BaseTests;

import Pages.*;
import Resources.SignUpData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends SetUp {
    @Test(dataProviderClass= SignUpData.class,dataProvider = ("SignUpData(name,gender,email,password,day,month,year)"))
    public void LoginUserWithCorrectEmailAndPassword(String name,String gender,String email,String password,String day,String month,String year)
    {

       AccountCreatedPage accountCreatedPage=homePage.Register(name,gender,email,password,day,month,year);
       UserPage userPage=accountCreatedPage.ClickContinue();
       LoginOrSignUpPage loginOrSignUpPage =userPage.LogOut();
       UserPage userPage1=loginOrSignUpPage.LoginWith(email,password);
       System.out.println(userPage.GetLoggedInAS());
       Assert.assertTrue(userPage.GetLoggedInAS().contains("Logged in as "+name),"Logged in Failed");
       DeletedAccountPage deletedAccountPage=userPage1.DeleteAccount();
       Assert.assertEquals(deletedAccountPage.GetDeletedMsg(),"ACCOUNT DELETED!","Account didn't deleted");
    }
}
