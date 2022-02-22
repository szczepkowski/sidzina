package pl.goreit.sidzina;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@Profile("test")
public class ContactSeleniumTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @BeforeEach()
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyGitHubTitle() throws InterruptedException {
        driver.get("http://192.168.187:4200");

        driver.findElement(By.partialLinkText("Kontakt")).click();
        driver.findElement(By.id("title")).sendKeys("value", "Prosze o dodanie firmy do listy");
        driver.findElement(By.id("text")).sendKeys("value", "Firma to GoreIT - ELastyczne oprogramowanie");
        driver.findElement(By.id("email")).sendKeys("value", "goreit1@gmail.com");
        driver.findElement(By.id("city")).sendKeys("value", "wroclaw");
        Thread.sleep(1000);

        WebElement preSubmit = driver.findElement(By.id("submit"));
        driver.findElement(By.id("submit")).submit();


        assertThat(driver.getTitle(), containsString("sidzina - Elastyczne oprogrwamowanie"));
    }
}