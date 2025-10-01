import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ExampleLink {

    WebDriver driver;
@BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    // Navigate to dashboard
    @Test
    public void linkTest(){
    WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));

    homeLink.click();
    driver.navigate().back();

        //Find destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link is going to : " + path);


        //Broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if (title.contains("404")){
        System.out.println("Link is Broken");
        }
        else {
            System.out.println("not broken");
        }
        driver.navigate().back();


        //Duplicate link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //Count page links
        List<WebElement> countFullLink =  driver.findElements(By.tagName("a"));
        int pageLinkCount = countFullLink.size();
        System.out.println("Count of full page link : " + pageLinkCount);


        //count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLink = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links : " + countOfLayoutLink.size());
      }


}
