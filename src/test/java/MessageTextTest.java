import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MessageTextTest {

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
        driver.manage().window().maximize();
        return driver;
    }


    @Test
    public void checkTextPositiveTest() {
        WebDriver driver = getDriver();
        WebElement textArea = driver.findElement(By.name("text"));
        textArea.sendKeys("Oddam za darmo nowy plecak z metką");
        driver.quit();
    }


    @Test
    public void checkEmptyMessageNegativeTest() {
        WebDriver driver = getDriver();
        WebElement textArea1 = driver.findElement(By.xpath("//*[@id='text']"));
        textArea1.sendKeys("");
        driver.quit();
    }


    @Test
    public void checkSpacesMessageNegativeTest() {
        WebDriver driver = getDriver();
        WebElement textArea2 = driver.findElement(By.id("text"));
        textArea2.sendKeys("  ");
        driver.quit();
    }

}
