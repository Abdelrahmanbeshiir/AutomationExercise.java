package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver)
    {
      super(driver);
    }
    public Boolean VerfiyProductDetail()
    {
        return driver.findElement(By.xpath("//*[contains(text(), 'Category')]")).isDisplayed()
                && driver.findElement(By.xpath("//*[contains(text(), 'Availability')]")).isDisplayed()
                && driver.findElement(By.xpath("//*[contains(text(), 'Brand:')]")).isDisplayed();
    }
}
