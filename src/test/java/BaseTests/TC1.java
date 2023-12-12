package BaseTests;
import Pages.*;
import Resources.SignUpData;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1 extends SetUp{

//
    @Test(dataProviderClass= SignUpData.class,dataProvider = ("SignUpData(name,gender,email,password,day,month,year)"))
    public void TestRegister(String name,String gender,String email,String password,String day,String month,String year)
    {

        AccountCreatedPage accountCreatedPage=homePage.Register(name,gender,email,password,day,month,year);
        Assert.assertEquals(accountCreatedPage.GetText(),"ACCOUNT CREATED!","Account doesn't Created");
        UserPage userPage=accountCreatedPage.ClickContinue();
        Assert.assertTrue(userPage.GetLoggedInAS().contains("Logged in as"),"Logged in Failed");
        DeletedAccountPage deletedAccountPage =userPage.DeleteAccount();
        Assert.assertEquals(deletedAccountPage.GetDeletedMsg(),"ACCOUNT DELETED!","Account didn't deleted");
        Assert.assertTrue(deletedAccountPage.ClickContinue().IsHomePageDisplayed());
    }



    @Test
    public void ScrollTest()
    {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(homePage.IsHomePageDisplayed());
        Assert.assertTrue(homePage.IsSubsDisplayed());
      Assert.assertTrue(homePage.GetSubsText().contains("SUBSCRIPTION"));
       homePage.ScrollTo();

    }

}
