package pl.goreit.sidzina;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {

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
    public void checkCorrectCityPositiveTest() {
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("Wrocław");
        String text = city.getAttribute("value");
        assertEquals("Wrocław", text);
    }


    @Test
    public void checkEmptyCityNegativeTest() {

        WebElement city1 = driver.findElement(By.cssSelector("[class*='ng-pristine ng-valid']"));
        city1.sendKeys("");
    }

    @Test
    public void checkIllegalCharactersCityNegativeTest() {
        WebElement city2 = driver.findElement(By.id("city"));
        city2.sendKeys("!!!!!!@@#");

    }

    @Test
    public void checkSpacesCityNegativeTest() {
        WebElement city3 = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/form/div/div[2]/div[2]/input"));
        city3.sendKeys("  ");

    }
}
