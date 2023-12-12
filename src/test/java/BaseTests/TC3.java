package BaseTests;
import Pages.LoginOrSignUpPage;
import Resources.SignUpData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC3 extends SetUp {
    @Test(dataProviderClass = SignUpData.class,dataProvider = "InValidLoginData(email,password)")

    public void LoginUserWithInCorrectEmailAndPassword (String email,String password)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginOrSignUpPage loginOrSignUpPage =homePage.ClickSignup();
        loginOrSignUpPage.LoginWith(email,password);
        Assert.assertEquals(loginOrSignUpPage.FailedLoginMsg(),"Your email or password is incorrect!");

    }
}
