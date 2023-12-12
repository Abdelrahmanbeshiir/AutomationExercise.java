package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CheckOut extends BasePage{
    public CheckOut(WebDriver driver)
    {
        super(driver);
    }
    By Placeorder =By.xpath("//* [@class='btn btn-default check_out']");
    WebElement PlaceOrder= driver.findElement(Placeorder);

    public void EnterComment(String s)
    {
        driver.findElement(By.xpath("//* [@class='form-control']")).sendKeys(s);
    }
    public PaymentPage ClickPlaceOrder()
    {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

      ClickingOn(PlaceOrder);
        return new PaymentPage(driver);
    }

}
