package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginOrSignUpPage extends BasePage{
    By SignupForm= By.className("signup-form");
    By NameField=By.xpath("//input [@data-qa='signup-name']");
    WebElement nameField=driver.findElement(NameField);
    By EmailField=By.xpath("//input [@data-qa='signup-email']");
    WebElement emailField=driver.findElement(EmailField);
    By LoginButton=By.xpath("//* [text()='Login']");
    WebElement LoginEmailField=driver.findElement(By.xpath("//* [@data-qa='login-email']"));
    WebElement PasswordField=driver.findElement(By.xpath("//* [@name='password']"));
    By SignUpButton=By.xpath("//button [@data-qa='signup-button']");

    public LoginOrSignUpPage(WebDriver driver)
    {
        super(driver);
    }
    public Boolean IsSignupVisible()
    {
        return driver.findElement(SignupForm).isDisplayed();
    }
    public void EnterEmail(String email)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        SendText(emailField,email);
    }
    public void EnterName(String name)
    {
        SendText(nameField,name);
    }

    public AccountInfoPage ClickSignup() {
        driver.findElement(SignUpButton).click();
        return new AccountInfoPage(driver);
    }
    public LoginOrSignUpPage SignupWithAlreadyExist(String name,String email) {
        EnterEmail(email);
        EnterName(name);
        driver.findElement(SignUpButton).click();
        return new LoginOrSignUpPage(driver);
    }


    public AccountInfoPage SignUpWith(String name,String email) throws NoSuchElementException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            EnterEmail(email);
            EnterName(name);
            ClickSignup();
            return new AccountInfoPage(driver);
    }

    public UserPage LoginWith(String email,String password)
    {
       driver.findElement(By.xpath("//* [@data-qa='login-email']")).sendKeys(email);
        driver.findElement(By.xpath("//* [@name='password']")).sendKeys(password);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(LoginButton).click();
        return new UserPage(driver);}

    public Boolean IsEmailExist()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       return driver.findElement(By.xpath("//* [text()='Email Address already exist!']")).isDisplayed();
    }
    public String FailedLoginMsg()
    {
        return driver.findElement(By.xpath("//* [text()=\"Your email or password is incorrect!\"]")).getText();
    }



}
