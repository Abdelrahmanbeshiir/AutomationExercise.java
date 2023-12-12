package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    By ConfirmOrder=By.id("submit");
    public PaymentPage(WebDriver driver)
    {
        super(driver);
    }
    public ConfirmedOrderPage EnterCardDataAndConfirm(String name,String cardNo,String cvc,String month,String years)
    {
        driver.findElement(By.name("name_on_card")).sendKeys(name);
        driver.findElement(By.name("card_number")).sendKeys(cardNo);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        driver.findElement(By.name("expiry_month")).sendKeys(month);
        driver.findElement(By.name("expiry_year")).sendKeys(years);
        driver.findElement(ConfirmOrder).click();
        return new ConfirmedOrderPage(driver);
    }
}
