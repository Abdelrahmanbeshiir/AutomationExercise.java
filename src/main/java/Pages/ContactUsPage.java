package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends BasePage{
    By Namefield=By.name("name");
    By EmailField=By.name("email");
    By SubjectField=By.name("subject");
    By MessageField=By.name("message");
    By ContactUsTitle=By.xpath("//* [text()='Get In Touch']");
    WebElement GetInTouchMsg=driver.findElement(ContactUsTitle);
    ContactUsPage(WebDriver driver)
    {
        super(driver);
    }
    public Boolean IsGetInTouchDisplayed()
    {
     return IsDisplayedAs(GetInTouchMsg,"Get In Touch");
    }
    public void EnterEmailNameSubjectMessage(String name,String email,String subject,String Msg)
    {
        SendText(driver.findElement(Namefield),name );
        SendText(driver.findElement(EmailField),email );
        SendText(driver.findElement(SubjectField),subject );
        SendText(driver.findElement(MessageField),Msg);
    }
    public void ChooseFile(String path)
    {
        driver.findElement(By.name("upload_file")).sendKeys(path);
    }
    public void ClickSubmit()
    {
        ClickingOn(driver.findElement(By.name("submit")));
    }
    public void AcceptAlert()
    {
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    public String GetSuccessMsg()
    {
        return driver.findElement(By.xpath("//* [@class='status alert alert-success']")).getText();
    }
    public HomePage ClickHome()
    {
        driver.findElement(By.xpath("//* [@class='btn btn-success']")).click();
        return new HomePage(driver);
    }
}
