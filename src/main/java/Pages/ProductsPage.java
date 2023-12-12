package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }
    private    By SearchForProducts=By.id("search_product");
    private WebElement Search=driver.findElement(SearchForProducts);
    private  By SearchButton=By.id("submit_search");

    WebElement ContinueShopping=driver.findElement(By.xpath("//* [text()='Continue Shopping']"));
    WebElement ViewCart=driver.findElement(By.xpath("//* [text()='View Cart']"));
    public String GetProductPageTitle()
    {
        return driver.findElement(By.xpath("//* [@class='title text-center']")).getText();
    }
    public ProductPage ClickOnProduct()
    {
      ClickingOn(driver.findElement(By.xpath("//* [@href='/product_details/1']")));
        return new ProductPage(driver);
    }
   public void SearchForProduct(String productName)
    {
        SendText(Search,productName);
        ClickingOn(driver.findElement(SearchButton));
    }
    public Boolean CheckSearchResultsRelatedTo(String productName)
    {
        List<WebElement> list=driver.findElements(By.className("col-sm-4"));
        List<String>ResultsNames=new ArrayList<>();

        boolean Check=true;
        for (WebElement element:list)
        {
          ResultsNames.add(element.getText());
            System.out.println(element.getText());
        }
        if (ResultsNames.isEmpty()) {
            System.out.println("try different search name");
            return null;
        }
        else
        for (String result:ResultsNames)
        {
            for (int i=0;i<ResultsNames.size()-1;i++)
            {
                Check= result.contains(productName);
            }
        }
        Check=Check&Check;

        return Check;
    }
    public  void AddProductToCart(int i)
    {
        ScrollDownTo(By.xpath("//* [@data-product-id='"+i+"']"));
        ClickingOn(driver.findElement(By.xpath("(//a [@data-product-id='"+i+"'] )[1]")));

    }

    public void ContinueShopping()
    {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ClickingOn(ContinueShopping);
    }
    public CartPage ClickViewCart()
    {
        ClickingOn(ViewCart);
        return new CartPage(driver);
    }
    public  String GetProductPrice(int i)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElement(By.xpath("(//div [@class='productinfo text-center'][1] //h2 )["+i+"]")).getText();
    }






}
