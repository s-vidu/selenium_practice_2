import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBox {
    WebDriver driver;
    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("139");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void textBoxTests(){
        //Type name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Vidumali Dahanayake");

        //Append country to this city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //Verify text is disabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Tesxt Box enabled"+enabled);

        //Clear Text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //Type email and tab. to confirm control move  to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("vidumalid@gmail.com" + Keys.TAB + "confirmed control moved to next element");

    }

}
