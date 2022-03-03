import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class KontaktSeleniumTest {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
        return driver;
    }

    @Test
    public void sendMessageTest() {
        WebDriver driver = getDriver();
        WebElement title = driver.findElement(By.id("title"));
        title.sendKeys("Ogłoszenie");
        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("Oddam rowerek dla dziecka. Odbiór osobisty ");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Mkasia@com.pl");
        WebElement miasto = driver.findElement(By.id("city"));
        miasto.sendKeys("Sidzina");
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
        //driver.quite();
    }

    @Test
    public void cannotClickButtonWithNoTitleTest() {
        WebDriver driver = getDriver();
        WebElement button = driver.findElement(By.id("submit"));
        assertFalse(button.isEnabled());
    }


}

