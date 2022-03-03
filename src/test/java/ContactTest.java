import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

public class ContactTest {

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    public WebDriver getDriver() {
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
    public void checkEditableTitlePositiveTest() {
        WebDriver driver = getDriver();
        WebElement title2 = driver.findElement(By.cssSelector("#city"));
        title2.isEnabled();
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

    @Test
    public void checkTextPositiveTest() {
        WebDriver driver = getDriver();
        WebElement textArea = driver.findElement(By.name("text"));
        textArea.sendKeys("Oddam za darmo nowy plecak z metką");
        driver.quit();
    }


    @Test
    public void checkEmptyMessageNegativeTest() {
        WebDriver driver = getDriver();
        WebElement textArea1 = driver.findElement(By.xpath("//*[@id='text']"));
        textArea1.sendKeys("");
        driver.quit();
    }


    @Test
    public void checkSpacesMessageNegativeTest() {
        WebDriver driver = getDriver();
        WebElement textArea2 = driver.findElement(By.id("text"));
        textArea2.sendKeys("  ");
        driver.quit();
    }


    @Test
    public void checkEditableTextPositiveTest() {
        WebDriver driver = getDriver();
        WebElement textArea3 = driver.findElement(By.id("text"));
        textArea3.isEnabled();
        driver.quit();
    }

    @Test
    public void checkMailPositiveTest() {
        WebDriver driver = getDriver();
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys("masa@com.pl");
        driver.quit();
    }


    @Test
    public void checkEditableMailPositiveTest() {
        WebDriver driver = getDriver();
        WebElement mail1 = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        mail1.isEnabled();
        driver.quit();
    }

    @Test
    public void checkIncorrectMailNegativeTest() {
        WebDriver driver = getDriver();
        WebElement mail2 = driver.findElement(By.id("email"));
        mail2.sendKeys("asdsadd");
        driver.quit();
    }


    @Test
    public void checkSpaceMailNegativeTest() {
        WebDriver driver = getDriver();
        WebElement mail3 = driver.findElement(By.cssSelector("#email"));
        mail3.sendKeys(" ");
        driver.quit();
    }

    @Test
    public void checkCorrectCityPositiveTest() {
        WebDriver driver = getDriver();
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("Wrocław");
        driver.quit();
    }


    @Test
    public void checkEmptyCityNegativeTest() {
        WebDriver driver = getDriver();
        WebElement city1 = driver.findElement(By.cssSelector("[class*='ng-pristine ng-valid']"));
        city1.sendKeys("");
        driver.quit();
    }

    @Test
    public void checkIllegalCharactersCityNegativeTest() {
        WebDriver driver = getDriver();
        WebElement city2 = driver.findElement(By.id("city"));
        city2.sendKeys("!!!!!!@@#");
        driver.quit();
    }

    @Test
    public void checkSpacesCityNegativeTest() {
        WebDriver driver = getDriver();
        WebElement city3 = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/form/div/div[2]/div[2]/input"));
        city3.sendKeys("  ");
        driver.quit();
    }


    @Test
    public void checkEditableCityPositiveTest() {
        WebDriver driver = getDriver();
        WebElement city4 = driver.findElement(By.name("city"));
        city4.isEnabled();
        driver.quit();
    }

}

