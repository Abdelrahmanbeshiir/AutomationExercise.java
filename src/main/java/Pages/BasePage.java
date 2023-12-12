package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    protected String GetText(By element)
    {
        return driver.findElement(element).getText();
    }
    protected void SendText(WebElement element,String string)
    {
        element.sendKeys(string);
    }

    protected String GetPageTitle()
    {
        return driver.getTitle();
    }
    protected void ClickingOn(WebElement e){
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(e));
        e.click();}
    protected  void ScrollDownTo(By by)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(by));
    }
    protected Boolean IsDisplayedAs(WebElement e,String string)
    {
        return e.isDisplayed();
    }


}
