package pl.goreit.sidzina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailTest {

    private WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    @AfterEach()
    public void tearDown() {
        this.driver.quit();
    }

    @BeforeEach
    public void getDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
    }


    @Test
    public void checkMailPositiveTest() {
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys("masa@com.pl");
    }


    @Test
    public void checkIncorrectMailNegativeTest() {
        WebElement mail2 = driver.findElement(By.id("email"));
        mail2.sendKeys("asdsadd");
    }


    @Test
    public void checkSpaceMailNegativeTest() {
        WebElement mail3 = driver.findElement(By.cssSelector("#email"));
        mail3.sendKeys(" ");
    }
}
