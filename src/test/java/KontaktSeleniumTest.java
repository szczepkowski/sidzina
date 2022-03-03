import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class KontaktSeleniumTest {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
        return driver;
    }


    @Test
    public void contactPositiveTest() {
        WebDriver driver = getDriver();
        WebElement titleField = driver.findElement(By.id("title"));
        WebElement textArea = driver.findElement(By.id("text"));
        WebElement mailField = driver.findElement(By.name("email"));
        WebElement cityField = driver.findElement(By.name("city"));
        WebElement buttonSubmit = driver.findElement(By.cssSelector("button[class='btn btn-primary mt-3 mb-3']"));
        driver.quit();
    }


    @Test
    public void selectorTest() {
        WebDriver driver = getDriver();
        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        driver.quit();
    }

    @Test
    public void xpathTest() {
        WebDriver driver = getDriver();
        WebElement miasto = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/form/div/div[2]/div[2]/input"));
        driver.quit();
    }

    @Test
    public void xpathTest2() {
        WebDriver driver = getDriver();
        WebElement text12 = driver.findElement(By.xpath("//*[@id='text']"));
        driver.quit();
    }


    @Test
    public void checkGroupElementsTest() {
        WebDriver driver = getDriver();
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        driver.quit();
    }


    @Test
    public void enterTitlePositiveTest() {
        WebDriver driver = getDriver();
        WebElement titleField = driver.findElement(By.id("title"));
        driver.findElement(By.id("title")).sendKeys("I Love You");
        WebElement textField = driver.findElement(By.id("text"));
        driver.findElement(By.id("text")).sendKeys("Za duzo by to opisac");
        WebElement emailField = driver.findElement(By.id("email"));
        driver.findElement(By.id("email")).sendKeys("milosna skrzyneczka");
        WebElement cityField = driver.findElement(By.id("city"));
        driver.findElement(By.id("city")).sendKeys("love love love");
        //driver.quite();
    }


    @Test
    public void clickSubmitPositiveTest() {
        WebDriver driver = getDriver();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        //driver.quite():
    }


    @Test
    public void searchInfo() {
        WebDriver driver = getDriver();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.quit();
    }


    //Testy do Projektu OpenSource

    @Test
    public void sendMessageTest() {
        WebDriver driver = getDriver();
        WebElement title = driver.findElement(By.id("title"));
        title.sendKeys("Ogłoszenie");
        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("Oddam rowerek dla dziecka. Odbiór osobisty ");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Mkasia@com.pl");
        WebElement miasto = driver.findElement(By.id("city"));
        miasto.sendKeys("Sidzina");
        WebElement bottom = driver.findElement(By.id("submit"));
        bottom.click();
        //driver.quite();
    }

    /////////////////////////////////////
    @Test
    public void checkTitlePositiveTest() {
        WebDriver driver = getDriver();
        WebElement titleArea = driver.findElement(By.id("title"));
        titleArea.sendKeys("Moje miasto");
        driver.quit();
    }


    @Test
    public void checkEmptyTitleNegativeTest() {
        WebDriver driver = getDriver();
        WebElement emptyTitle = driver.findElement(By.id("title"));
        emptyTitle.sendKeys("");
        driver.quit();
    }

    @Test
    public void spaceTitleNegativeTest() {
        WebDriver driver = getDriver();
        WebElement spaceTitle = driver.findElement(By.id("title"));
        spaceTitle.sendKeys(" ");
        driver.quit();
    }


    @Test
    public void illegalCharactersTitleNegativeTest() {
        WebDriver driver = getDriver();
        WebElement spaceTitle2 = driver.findElement(By.id("title"));
        spaceTitle2.sendKeys(" !%!@");
        driver.quit();
    }


    @Test
    public void tooManyCharaktersTitleTest() {
        WebDriver driver = getDriver();
        WebElement spaceTitle3 = driver.findElement(By.id("title"));
        spaceTitle3.sendKeys("awfddddddddddddddddddfawwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwpkhoitjjodasf-098re");
        driver.quit();
    }

    @Test
    public void checkSubmitNegativeTest() {
        WebDriver driver = getDriver();
        WebElement bottom = driver.findElement(By.id("submit"));
        assertFalse(bottom.isEnabled());
        driver.quit();
    }

}