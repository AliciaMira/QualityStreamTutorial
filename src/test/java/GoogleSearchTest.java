import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    private WebDriver driver;

    public GoogleSearchTest() {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://www.google.com/");
    }

    @Test
    public void testGooglePage() {
        WebElement searchbox = this.driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys(new CharSequence[]{"Introducción a la Automatización de Pruebas de Software"});
        searchbox.submit();
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        Assert.assertEquals("Introducción a la Automatización de Pruebas de Software - Buscar con Google", this.driver.getTitle());
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }
}
