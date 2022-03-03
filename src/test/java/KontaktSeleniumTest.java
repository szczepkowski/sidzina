import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KontaktSeleniumTest {

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
    public void sendMessageTest() throws InterruptedException {
        WebElement title = driver.findElement(By.id("title"));
        title.sendKeys("Ogłoszenie");
        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("Oddam rowerek dla dziecka. Odbiór osobisty ");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Mkasia@com.pl");
        WebElement miasto = driver.findElement(By.id("city"));
        miasto.sendKeys("Sidzina");
        WebElement button = driver.findElement(By.id("submit"));
        assertTrue(button.isEnabled());
        button.submit();
    }

    @Test
    public void cannotClickButtonWithNoTitleTest() {
        WebElement button = driver.findElement(By.id("submit"));
        assertFalse(button.isEnabled());
    }

}

