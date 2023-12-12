package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
    }
    public String GetLoggedInAS()
    {
        return driver.findElement(By.xpath(" //* [text()=' Logged in as '] ")).getText();

    }
    public DeletedAccountPage DeleteAccount()
    {
        driver.findElement(By.xpath("//i [@class='fa fa-trash-o']")).click();
        return new DeletedAccountPage(driver);

    }
    public LoginOrSignUpPage LogOut()
    {
        driver.findElement(By.partialLinkText("Logout")).click();
        return new LoginOrSignUpPage(driver);
    }
    public CartPage GoToCart()
    {
        ClickingOn(driver.findElement(By.xpath("//a [contains(text(),'Cart')]")));
        return new CartPage(driver);
    }



}
