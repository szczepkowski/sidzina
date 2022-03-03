import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleTest {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://192.168.0.167:4200/kontakt");
        return driver;
    }


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
    public void tooManyCharaktersTitleNegativeTest() {
        WebDriver driver = getDriver();
        WebElement spaceTitle3 = driver.findElement(By.id("title"));
        spaceTitle3.sendKeys("awfddddddddddddddddddfawwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwpkhoitjjodasf-098re");
        driver.quit();
    }
}
