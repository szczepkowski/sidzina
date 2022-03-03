package pl.goreit.sidzina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityTest {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
        return driver;
    }

    @Test
    public void checkCorrectCityPositiveTest() {
        WebDriver driver = getDriver();
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("Wrocław");
        //driver.quit();
    }


    @Test
    public void checkEmptyCityNegativeTest() {
        WebDriver driver = getDriver();
        WebElement city1 = driver.findElement(By.cssSelector("[class*='ng-pristine ng-valid']"));
        city1.sendKeys("");
        driver.quit();
    }

    @Test
    public void checkIllegalCharactersCityNegativeTest() {
        WebDriver driver = getDriver();
        WebElement city2 = driver.findElement(By.id("city"));
        city2.sendKeys("!!!!!!@@#");
        driver.quit();
    }

    @Test
    public void checkSpacesCityNegativeTest() {
        WebDriver driver = getDriver();
        WebElement city3 = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/form/div/div[2]/div[2]/input"));
        city3.sendKeys("  ");
        driver.quit();
    }
}
