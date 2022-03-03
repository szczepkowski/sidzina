import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

public class ContactTest {

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
    public void checkTitlePositiveTest() {
        WebElement titleArea = driver.findElement(By.id("title"));
        titleArea.sendKeys("Moje miasto");
    }

    @Test
    public void checkEditableTitlePositiveTest() {
        WebElement title2 = driver.findElement(By.cssSelector("#city"));
        title2.isEnabled();
    }


    @Test
    public void checkEmptyTitleNegativeTest() {
        WebElement emptyTitle = driver.findElement(By.id("title"));
        emptyTitle.sendKeys("");
    }


    @Test
    public void spaceTitleNegativeTest() {
        WebElement spaceTitle = driver.findElement(By.id("title"));
        spaceTitle.sendKeys(" ");
    }


    @Test
    public void illegalCharactersTitleNegativeTest() {
        WebElement spaceTitle2 = driver.findElement(By.id("title"));
        spaceTitle2.sendKeys(" !%!@");
    }


    @Test
    public void tooManyCharaktersTitleNegativeTest() {
        WebElement spaceTitle3 = driver.findElement(By.id("title"));
        spaceTitle3.sendKeys("awfddddddddddddddddddfawwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwpkhoitjjodasf-098re");
    }

    @Test
    public void checkTextPositiveTest() {
        WebElement textArea = driver.findElement(By.name("text"));
        textArea.sendKeys("Oddam za darmo nowy plecak z metką");
    }


    @Test
    public void checkEmptyMessageNegativeTest() {
        WebElement textArea1 = driver.findElement(By.xpath("//*[@id='text']"));
        textArea1.sendKeys("");
    }


    @Test
    public void checkSpacesMessageNegativeTest() {
        WebElement textArea2 = driver.findElement(By.id("text"));
        textArea2.sendKeys("  ");
    }


    @Test
    public void checkEditableTextPositiveTest() {
        WebElement textArea3 = driver.findElement(By.id("text"));
        textArea3.isEnabled();
    }

    @Test
    public void checkMailPositiveTest() {
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys("masa@com.pl");
    }


    @Test
    public void checkEditableMailPositiveTest() {
        WebElement mail1 = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        mail1.isEnabled();
    }

    @Test
    public void checkIncorrectMailNegativeTest() {
        WebElement mail2 = driver.findElement(By.id("email"));
        mail2.sendKeys("asdsadd");

    }


    @Test
    public void checkSpaceMailNegativeTest() {
        WebElement mail3 = driver.findElement(By.cssSelector("#email"));
        mail3.sendKeys(" ");
    }

    @Test
    public void checkCorrectCityPositiveTest() {
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("Wrocław");
    }


    @Test
    public void checkEmptyCityNegativeTest() {
        WebElement city1 = driver.findElement(By.cssSelector("[class*='ng-pristine ng-valid']"));
        city1.sendKeys("");
    }

    @Test
    public void checkIllegalCharactersCityNegativeTest() {
        WebElement city2 = driver.findElement(By.id("city"));
        city2.sendKeys("!!!!!!@@#");
    }

    @Test
    public void checkSpacesCityNegativeTest() {
        WebElement city3 = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/form/div/div[2]/div[2]/input"));
        city3.sendKeys("  ");
    }


    @Test
    public void checkEditableCityPositiveTest() {
        WebElement city4 = driver.findElement(By.name("city"));
        city4.isEnabled();
    }

}

