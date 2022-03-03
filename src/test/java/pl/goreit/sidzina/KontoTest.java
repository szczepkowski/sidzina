package pl.goreit.sidzina;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.system.SystemProperties;

import java.util.List;

public class KontoTest {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://192.168.0.167:4200/konto");
        driver.manage().window().maximize();
        return driver;
    }


    @Test
    public void clickPortfolioPositiveTest() {
        WebDriver driver = getDriver();
        WebElement portfoliobutton = driver.findElement(By.cssSelector("body > app-root > div > app-account > div > div.d-lg-inline-block > a > h3 > u"));
        portfoliobutton.click();
        driver.quit();
    }


    @Test
    public void clickFacebookPositiveTest() {
        WebDriver driver = getDriver();
        WebElement facebookbutton = driver.findElement(By.xpath("/html/body/app-root/div/app-footer/nav/div[1]/a"));
        facebookbutton.click();
        driver.quit();
    }


    @Test
    public void clickGoreItPositiveTest() {
        WebDriver driver = getDriver();
        WebElement goreItbutton = driver.findElement(By.xpath("/html/body/app-root/div/app-footer/nav/div[2]/a"));
        goreItbutton.click();
        driver.quit();
    }

    @Test
    public void existBorderPositiveTest() {
        WebDriver driver = getDriver();
        List<WebElement> border = driver.findElements(By.className("mt-3"));
        if (border.size() > 0) {
            System.out.println("Istnieje");
        } else {
            System.out.println("Nie istnieje");
        }
        driver.quit();
    }


    @Test
    public void existBorder2PositiveTest() {
        WebDriver driver = getDriver();
        List<WebElement> border2 = driver.findElements(By.cssSelector("body > app-root > div > app-account > div"));
        if (border2.size() > 0) {
            System.out.println("Istnieje");
        } else {
            System.out.println("Nie istnieje");
        }
        driver.quit();
}
}