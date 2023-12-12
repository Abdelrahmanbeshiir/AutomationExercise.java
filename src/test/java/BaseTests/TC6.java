package BaseTests;

import Pages.ContactUsPage;
import Resources.ContactUsData;
import Resources.SignUpData;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.security.auth.Subject;

public class TC6 extends SetUp{
    @Test(dataProviderClass= ContactUsData.class,dataProvider = ("ContactusData(name,email,subject,msg)"))
    public void TestContactUs(String name, String email, String subject,String msg)
    {
        ContactUsPage contactUsPage=homePage.ClickContactUs();
        Assert.assertTrue(contactUsPage.IsGetInTouchDisplayed());
        contactUsPage.EnterEmailNameSubjectMessage(name,email,subject,msg);
        contactUsPage.ChooseFile("C:\\Users\\abdelrahman\\Desktop\\ISTQB.png");
        contactUsPage.ClickSubmit();
        contactUsPage.AcceptAlert();
        Assert.assertEquals(contactUsPage.GetSuccessMsg(),"Success! Your details have been submitted successfully.");
        Assert.assertTrue(contactUsPage.ClickHome().IsHomePageDisplayed());
    }
}
