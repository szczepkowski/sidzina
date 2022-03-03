package pl.goreit.sidzina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

import java.lang.annotation.Target;

public class EmailTest {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
        driver.manage().window().maximize();
        return driver;
    }


    @Test
    public void checkMailPositiveTest() {
        WebDriver driver = getDriver();
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys("masa@com.pl");
        driver.quit();
    }


    @Test
    public void checkIncorrectMailNegativeTest() {
        WebDriver driver = getDriver();
        WebElement mail2 = driver.findElement(By.id("email"));
        mail2.sendKeys("asdsadd");
        //driver.quit();
    }


    @Test
    public void checkSpaceMailNegativeTest() {
        WebDriver driver = getDriver();
        WebElement mail3 = driver.findElement(By.cssSelector("#email"));
        mail3.sendKeys(" ");
        driver.quit();
    }
}
