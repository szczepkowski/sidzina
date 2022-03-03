package pl.goreit.sidzina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.goreit.sidzina.configuration.config.WebConfig;

public class HomeTest {
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
    public void displayingElementPositiveTest2() throws InterruptedException {
        Thread.sleep(1000);
        WebElement infoText2 = driver.findElement(By.xpath("/html/body/app-root/div/app-header/div[2]/a[1]/span"));
        infoText2.isDisplayed();
    }

    @Test
    public void enabledElementPositiveTest() {
        WebElement button1 = driver.findElement(By.xpath("/html/body/app-root/div/app-header/div[1]/p/b"));
        button1.isEnabled();
    }


    @Test
    public void enabledElementPositiveTest2() {
        WebElement button2 = driver.findElement(By.className("m-3"));
        button2.isEnabled();
    }
}