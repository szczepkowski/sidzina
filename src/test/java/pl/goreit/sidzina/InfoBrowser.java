package pl.goreit.sidzina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfoBrowser {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://192.168.0.167:4200/");
        driver.manage().window().maximize();
        return driver;
    }


    @Test
    public void getInfoBrowser2() {
        WebDriver driver = getDriver();
        System.out.println("Adres:" + driver.getCurrentUrl());
        System.out.println("Tytuł:" + driver.getTitle());
        System.out.println("Source:" + driver.getPageSource());
        driver.quit();

    }
}
