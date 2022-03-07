package pl.goreit.sidzina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionsTest {
    private WebDriver driver;


    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    @BeforeEach
    public void getDriver() {
        driver = new ChromeDriver();
        driver.navigate().to("http://192.168.0.168:4200/konto");
    }

    @AfterEach()
    public void tearDrown() {
        this.driver.quit();
    }


    @Test
    public void addAuctionPositiveTest() throws InterruptedException {
        WebElement addAuctionButton = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[2]/ul/li/a/span"));
        addAuctionButton.click();
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("Sprzedam rower");
        assertEquals("Sprzedam rower", titleField.getAttribute("value"));
        WebElement textArea = driver.findElement(By.id("description"));
        textArea.sendKeys("Rower górski dla 5-7 latka. W bardzo dobrym stanie.");
        assertEquals("Rower górski dla 5-7 latka. W bardzo dobrym stanie.", textArea.getAttribute("value"));
        WebElement priceField = driver.findElement(By.id("price"));
        priceField.sendKeys("50zł/h");
        assertEquals("50zł/h", priceField.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//html/body/app-root/div/app-add-auction/div/form/div/button"));
        assertTrue(submit.isEnabled());
        submit.submit();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void addAuctionNegativeTest() throws InterruptedException {
        WebElement addAuctionButton = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[2]/ul/li/a/span"));
        addAuctionButton.click();
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(" ");
        assertEquals(" ", titleField.getAttribute("value"));
        WebElement textArea = driver.findElement(By.id("description"));
        textArea.sendKeys(" ");
        assertEquals(" ", textArea.getAttribute("value"));
        WebElement priceField = driver.findElement(By.id("price"));
        priceField.sendKeys(" ");
        assertEquals(" ", priceField.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//html/body/app-root/div/app-add-auction/div/form/div/button"));
        assertTrue(submit.isEnabled());
        submit.submit();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void addAuctionNegativeTest2() throws InterruptedException {
        WebElement addAuctionButton2 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[2]/ul/li/a/span"));
        addAuctionButton2.click();
        WebElement titleField2 = driver.findElement(By.id("title"));
        titleField2.sendKeys("Sprzedam rower");
        assertEquals("Sprzedam rower", titleField2.getAttribute("value"));
        WebElement textArea2 = driver.findElement(By.id("description"));
        textArea2.sendKeys("Rower górski dla 5-7 latka. W bardzo dobrym stanie.");
        assertEquals("Rower górski dla 5-7 latka. W bardzo dobrym stanie.", textArea2.getAttribute("value"));
        WebElement priceField2 = driver.findElement(By.id("price"));
        priceField2.sendKeys("-50zł/h");
        assertEquals("-50zł/h", priceField2.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//html/body/app-root/div/app-add-auction/div/form/div/button"));
        assertTrue(submit.isEnabled());
        submit.submit();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    @Test
    public void addAuctionNegativeTest3() throws InterruptedException {
        WebElement addAuctionButton3 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[2]/ul/li/a/span"));
        addAuctionButton3.click();
        WebElement titleField3 = driver.findElement(By.id("title"));
        titleField3.sendKeys("123");
        assertEquals("123", titleField3.getAttribute("value"));
        WebElement textArea3 = driver.findElement(By.id("description"));
        textArea3.sendKeys("Rower górski dla 5-7 latka. W bardzo dobrym stanie.");
        assertEquals("Rower górski dla 5-7 latka. W bardzo dobrym stanie.", textArea3.getAttribute("value"));
        WebElement priceField3 = driver.findElement(By.id("price"));
        priceField3.sendKeys("50,00009988727zł/h");
        assertEquals("50,00009988727zł/h", priceField3.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//html/body/app-root/div/app-add-auction/div/form/div/button"));
        assertTrue(submit.isEnabled());
        submit.submit();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}