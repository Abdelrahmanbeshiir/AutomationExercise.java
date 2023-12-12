package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver)
    {
        super(driver);
    }
    public String GetCartPriceForProduct(int i)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement((By.xpath("(//* [@class='cart_price'] )["+i+"]"))).getText();
    }
    public int GetProductQuantity(int i)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return Integer.parseInt(driver.findElement((By.xpath("(//* [@class='disabled'] )["+i+"]"))).getText());
    }
    public String GetProductTotal(int i)
    {
       return driver.findElement(By.xpath("(//* [@class='cart_total_price'] )["+i+"]")).getText();

    }
    public CheckOut ClickProceedToCheckout()
    {
        ClickingOn(driver.findElement(By.xpath("//* [@class='btn btn-default check_out']")));
        return new CheckOut(driver);
    }
    public LoginOrSignUpPage ClickRegister_login()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.findElement(By.xpath("(//a /u )[contains(text(),'Register')]")).click();
        return new LoginOrSignUpPage(driver);
    }

}
