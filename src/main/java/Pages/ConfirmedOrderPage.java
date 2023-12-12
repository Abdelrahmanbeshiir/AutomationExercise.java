package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmedOrderPage extends BasePage {
    By Confirmationmessage = By.xpath("//p [@style='font-size: 20px; font-family: garamond;']");
    public ConfirmedOrderPage(WebDriver driver)
    {
        super(driver);
    }
    public String GetConfirmationMsg()
    {
        return driver.findElement(Confirmationmessage).getText();
    }

}
