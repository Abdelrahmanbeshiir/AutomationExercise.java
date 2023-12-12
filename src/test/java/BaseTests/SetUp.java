package BaseTests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class SetUp {
    protected  HomePage homePage;
    protected  WebDriver driver;
    @BeforeClass
    public void Setup()
    {

        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
        homePage =new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(homePage.IsHomePageDisplayed(),"home page not displayed");
    }
    @AfterClass
    public void CloseBrowser()
    {
       driver.quit();
    }

}
