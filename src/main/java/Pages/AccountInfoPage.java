package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AccountInfoPage extends BasePage  {
    By EnterAccInfo= By.xpath("//* [text()='Enter Account Information']");
    By GenderBox1=By.id("id_gender1");
    By GenderBox2=By.id("id_gender2");
    By PasswordField=By.id("password");
    WebElement passwordField=driver.findElement(PasswordField);
    By Day=By.id("days");
    By months=By.id("months");
    By years=By.id("years");
    By newsLetter=By.id("newsletter");
    By receive=By.id("optin");
    By CreatAccountButton=By.xpath("//button [@data-qa='create-account']");

    public AccountInfoPage(WebDriver driver)
    {
        super(driver);
    }
    public Boolean IsEnterAccountInfoVisible()
    {
        return driver.findElement(EnterAccInfo).isDisplayed();
    }
    public void ChooseGender(String gender)
    {
        if(gender.equalsIgnoreCase("male"))
        {driver.findElement(GenderBox1).click();}
        else if (gender.equalsIgnoreCase("female"))
        {
            driver.findElement(GenderBox2).click();
        }
    }
    public void EnterPassword(String password)
    {
        SendText(passwordField,password);
    }

    public void SelectDay(String day)
    {
        Select select= new Select(driver.findElement(Day));
        select.selectByValue(day);
    }
    public void SelectMonth(String month)
    {
        Select select= new Select(driver.findElement(months));
        select.selectByValue(month);
    }
    public void SelectYear(String year)
    {
        Select select= new Select(driver.findElement(years));
        select.selectByValue(year);
    }
    public void ClickNewsLetter()
    {
        ScrollDownTo(By.id("address2"));

        driver.findElement(newsLetter).click();
    }
    public void ClickRecieve()
    {
        driver.findElement(receive).click();
    }

    public void EnterAddress()
    {
        driver.findElement(By.id("first_name")).sendKeys("abdo");
        driver.findElement(By.id("last_name")).sendKeys("ahmed");
        driver.findElement(By.id("company")).sendKeys("Top");
        driver.findElement(By.id("address1")).sendKeys("22");
        driver.findElement(By.id("address2")).sendKeys("23");
        Select Country= new Select(driver.findElement(By.id("country")));
        Country.selectByValue("India");
        driver.findElement(By.id("state")).sendKeys("Egypt");
        driver.findElement(By.id("city")).sendKeys("alex");
        driver.findElement(By.id("zipcode")).sendKeys("3124654");
        driver.findElement(By.id("mobile_number")).sendKeys("021124");
    }
    public AccountCreatedPage EnterDataAndClickCreatAccount(String gender,String password,String day,String month,String year)

    {

        ChooseGender(gender);
        EnterPassword(password);
        SelectDay(day);
        SelectMonth(month);
        SelectYear(year);
        ClickNewsLetter();
        ClickRecieve();
        EnterAddress();
         ScrollDownTo(CreatAccountButton);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(CreatAccountButton).click();
        return new AccountCreatedPage(driver);
    }



}
