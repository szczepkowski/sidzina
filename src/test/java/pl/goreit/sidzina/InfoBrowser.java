package pl.goreit.sidzina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoBrowser {

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
        driver.navigate().to("http://192.168.0.167:4200");
    }


    @Test
    public void getInfoBrowser2() {
        System.out.println("Adres:" + driver.getCurrentUrl());
        System.out.println("Tytuł:" + driver.getTitle());
        System.out.println("Source:" + driver.getPageSource());

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        String pageSource = driver.getPageSource();

        assertEquals("http://192.168.0.167:4200/", currentUrl);
        assertEquals("sidzina - Elastyczne oprogrwamowanie", title);
    }
}
