package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletedAccountPage extends BasePage {
    public DeletedAccountPage(WebDriver driver)
    {super(driver);}
    public String GetDeletedMsg()
    {
        return driver.findElement(By.xpath("//h2 [@class='title text-center']")).getText();
    }
    public HomePage ClickContinue()
    {
         driver.findElement(By.linkText("Continue")).click();
         return new HomePage(driver);
    }
}
