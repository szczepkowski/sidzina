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

public class OffertsTest {
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
    public void addServicePositiveTest() throws InterruptedException {
        WebElement addServiceButton = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[1]/ul/li/a/span"));
        addServiceButton.click();
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("Malowanie domu");
        assertEquals("Malowanie domu", titleField.getAttribute("value"));
        WebElement textArea = driver.findElement(By.id("description"));
        textArea.sendKeys("Oferuję malowanie domów wewnątrz i na zewnątrz. Posiadam wieloletnie doświadczenie. Praca wykonana dokładnie i w wyznaczonym terminie");
        assertEquals("Oferuję malowanie domów wewnątrz i na zewnątrz. Posiadam wieloletnie doświadczenie. Praca wykonana dokładnie i w wyznaczonym terminie", textArea.getAttribute("value"));
        WebElement priceField = driver.findElement(By.id("price"));
        priceField.sendKeys("50zł/h");
        assertEquals("50zł/h", priceField.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("/html/body/app-root/div/app-add-offer/div/form/div/button"));
        assertTrue(submit.isEnabled());
        submit.submit();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }



    @Test
    public void addServiceNegativeTest() throws InterruptedException {
        WebElement addServiceButton2 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[1]/ul/li/a/span"));
        addServiceButton2.click();
        WebElement titleField2 = driver.findElement(By.id("title"));
        titleField2.sendKeys("         ");
        assertEquals("         ", titleField2.getAttribute("value"));
        WebElement textArea2 = driver.findElement(By.id("description"));
        textArea2.sendKeys("Oferuję malowanie domów wewnątrz i na zewnątrz. Posiadam wieloletnie doświadczenie. Praca wykonana dokładnie i w wyznaczonym terminie");
        assertEquals("Oferuję malowanie domów wewnątrz i na zewnątrz. Posiadam wieloletnie doświadczenie. Praca wykonana dokładnie i w wyznaczonym terminie", textArea2.getAttribute("value"));
        WebElement priceField2 = driver.findElement(By.id("price"));
        priceField2.sendKeys("50zł/h");
        assertEquals("50zł/h", priceField2.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit2 = driver.findElement(By.xpath("/html/body/app-root/div/app-add-offer/div/form/div/button"));
        assertTrue(submit2.isEnabled());
        submit2.submit();

    }

    @Test
    public void addServiceNegativeTest2() throws InterruptedException {
        WebElement addServiceButton3 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[1]/ul/li/a/span"));
        addServiceButton3.click();
        WebElement titleField3 = driver.findElement(By.id("title"));
        titleField3.sendKeys("         ");
        assertEquals("         ", titleField3.getAttribute("value"));
        WebElement textArea3 = driver.findElement(By.id("description"));
        textArea3.sendKeys("      ");
        assertEquals("      ", textArea3.getAttribute("value"));
        WebElement priceField3 = driver.findElement(By.id("price"));
        priceField3.sendKeys("   ");
        assertEquals("   ", priceField3.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit3 = driver.findElement(By.xpath("/html/body/app-root/div/app-add-offer/div/form/div/button"));
        assertTrue(submit3.isEnabled());
        submit3.submit();
    }


    @Test
    public void addServicePriceNegativeTest() throws InterruptedException {
        WebElement addServiceButton4 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[1]/ul/li/a/span"));
        addServiceButton4.click();
        WebElement titleField4 = driver.findElement(By.id("title"));
        titleField4.sendKeys("Remont");
        assertEquals("Remont", titleField4.getAttribute("value"));
        WebElement textArea4 = driver.findElement(By.id("description"));
        textArea4.sendKeys("Podejmę się remontu dużych obiektów przemysłowych");
        assertEquals("Podejmę się remontu dużych obiektów przemysłowych", textArea4.getAttribute("value"));
        WebElement priceField4 = driver.findElement(By.id("price"));
        priceField4.sendKeys("-100zł");
        assertEquals("-100zł", priceField4.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit3 = driver.findElement(By.xpath("/html/body/app-root/div/app-add-offer/div/form/div/button"));
        assertTrue(submit3.isEnabled());
        submit3.submit();
    }


    @Test
    public void addServicePriceNegativeTest2() throws InterruptedException {
        WebElement addServiceButton5 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[1]/ul/li/a/span"));
        addServiceButton5.click();
        WebElement titleField5 = driver.findElement(By.id("title"));
        titleField5.sendKeys("Remont");
        assertEquals("Remont", titleField5.getAttribute("value"));
        WebElement textArea5 = driver.findElement(By.id("description"));
        textArea5.sendKeys("Podejmę się remontu dużych obiektów przemysłowych");
        assertEquals("Podejmę się remontu dużych obiektów przemysłowych", textArea5.getAttribute("value"));
        WebElement priceField5 = driver.findElement(By.id("price"));
        priceField5.sendKeys("100,9999999999zł");
        assertEquals("100,9999999999zł", priceField5.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit3 = driver.findElement(By.xpath("/html/body/app-root/div/app-add-offer/div/form/div/button"));
        assertTrue(submit3.isEnabled());
        submit3.submit();
    }


    @Test
    public void addServicePriceNegativeTest3() throws InterruptedException {
        WebElement addServiceButton6 = driver.findElement(By.xpath("/html/body/app-root/div/app-account/div/div[1]/ul/li/a/span"));
        addServiceButton6.click();
        WebElement titleField6 = driver.findElement(By.id("title"));
        titleField6.sendKeys("Remont");
        assertEquals("Remont", titleField6.getAttribute("value"));
        WebElement textArea6 = driver.findElement(By.id("description"));
        textArea6.sendKeys("Podejmę się remontu dużych obiektów przemysłowych");
        assertEquals("Podejmę się remontu dużych obiektów przemysłowych", textArea6.getAttribute("value"));
        WebElement priceField6 = driver.findElement(By.id("price"));
        priceField6.sendKeys("aazz@@!");
        assertEquals("aazz@@!", priceField6.getAttribute("value"));

        Thread.sleep(1000);
        WebElement submit3 = driver.findElement(By.xpath("/html/body/app-root/div/app-add-offer/div/form/div/button"));
        assertTrue(submit3.isEnabled());
        submit3.submit();
    }


}






