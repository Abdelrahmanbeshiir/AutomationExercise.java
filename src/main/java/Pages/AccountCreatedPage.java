package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AccountCreatedPage extends BasePage {
    By PageTitle= By.xpath("//* [@class='title text-center']");
    By Continue=By.xpath("//* [@data-qa='continue-button']");
    public AccountCreatedPage(WebDriver driver)
    {
        super(driver);
    }
    public String GetText()
    {
        return driver.findElement(PageTitle).getText();
    }
    public UserPage ClickContinue()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(Continue).click();
        return new UserPage(driver);
    }

}
