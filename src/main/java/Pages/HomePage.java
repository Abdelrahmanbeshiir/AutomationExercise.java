package Pages;

import org.openqa.selenium.*;

import java.time.Duration;

public class HomePage extends BasePage {

   By ContactUsButton =By.xpath("//* [@href='/contact_us']");
    WebElement ContactUs=driver.findElement(ContactUsButton);
    By featureitems = By.xpath("//* [@class='title text-center']");
    WebElement Home=driver.findElement(featureitems);
        By signUp = By.xpath("//i [@class='fa fa-lock']");
    WebElement SignUpButton=driver.findElement(signUp);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage ClickHome() {
        ClickingOn(Home);
        return new HomePage(driver);
    }
    public ContactUsPage ClickContactUs() {
        ClickingOn(ContactUs);
        return new ContactUsPage(driver);
    }

    public ProductsPage ClickProductsPage()
    {
        ClickingOn(driver.findElement(By.partialLinkText("Products")));
        return new ProductsPage(driver);
    }

    public String CheckHomePage() {
        return GetText(featureitems);
    }

    public Boolean IsHomePageDisplayed() {
        return driver.findElement(featureitems).isDisplayed();
    }

    public Boolean IsSignupDisplayed() {
        return SignUpButton.isDisplayed();
    }

    public LoginOrSignUpPage ClickSignup() {

        ClickingOn(SignUpButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return new LoginOrSignUpPage(driver);
    }

    public Boolean IsSubsDisplayed() {
        return driver.findElement(By.xpath("//* [@class='single-widget']")).isDisplayed();
    }

    public String GetSubsText() {
        return driver.findElement(By.xpath("//* [@class='single-widget']")).getText();
    }

    public void ScrollTo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", Home);
    }

    public AccountCreatedPage Register(String name, String gender, String email, String password, String day, String month, String year) {
        try {
            LoginOrSignUpPage loginOrSignUpPage = ClickSignup();
            AccountInfoPage accountInfoPage = loginOrSignUpPage.SignUpWith(name, email);
            accountInfoPage.EnterDataAndClickCreatAccount(gender,password,day,month,year);
            return new AccountCreatedPage(driver);
        } catch (NoSuchElementException e) {
            System.out.println("Email already Exists");
            return  null;
        }
    }
}






