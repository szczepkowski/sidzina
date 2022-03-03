package pl.goreit.sidzina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.goreit.sidzina.configuration.config.WebConfig;

public class HomeTest {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://192.168.0.167:4200/");
        driver.manage().window().maximize();
        return driver;
    }


    @Test
    public void displayingElementPositiveTest() throws InterruptedException {
        WebDriver driver = getDriver();
        Thread.sleep(1000);
        WebElement infoText = driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div"));
        infoText.isDisplayed();
        driver.quit();
    }


    @Test
    public void displayingElementPositiveTest2() throws InterruptedException {
        WebDriver driver = getDriver();
        Thread.sleep(1000);
        WebElement infoText2 = driver.findElement(By.cssSelector("body > app-root > div > app-footer > nav"));
        infoText2.isDisplayed();
        driver.quit();
    }

    @Test
    public void enabledElementPositiveTest() {
        WebDriver driver = getDriver();
        WebElement bottom1 = driver.findElement(By.xpath("/html/body/app-root/div/app-header/div[1]/p/b"));
        bottom1.isEnabled();
        driver.quit();
    }


    @Test
    public void enabledElementPositiveTest2() {
        WebDriver driver = getDriver();
        WebElement bottom2 = driver.findElement(By.className("m-3"));
        bottom2.isEnabled();
        driver.quit();
    }
}