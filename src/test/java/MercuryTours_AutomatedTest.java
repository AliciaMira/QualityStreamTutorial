import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
    private WebDriver driver;
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By userNameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerBtnLocator = By.name("submit");
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");
    By homePageLocator = By.xpath("//h3[contains(text(), 'Login Successfully')]");

    public MercuryTours_AutomatedTest() {
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://demo.guru99.com/test/newtours");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void registerUser() throws InterruptedException {
        this.driver.findElement(this.registerLinkLocator).click();
        Thread.sleep(2000L);
        if (this.driver.findElement(this.registerPageLocator).isDisplayed()) {
            this.driver.findElement(this.userNameLocator).clear();
            this.driver.findElement(this.userNameLocator).sendKeys("qualityadmin");
            this.driver.findElement(this.passwordLocator).clear();
            this.driver.findElement(this.passwordLocator).sendKeys("pass1");
            this.driver.findElement(this.confirmPasswordLocator).clear();
            this.driver.findElement(this.confirmPasswordLocator).sendKeys("pass1");
            this.driver.findElement(this.registerBtnLocator).click();
        } else {
            System.out.print("Register pages was not found");
        }

        List<WebElement> fonts = this.driver.findElements(By.tagName("font"));
        Assert.assertEquals("Note: Your user name is qualityadmin.", ((WebElement)fonts.get(5)).getText());
    }

    @Test
    public void signIn() throws InterruptedException {
        if (this.driver.findElement(this.userLocator).isDisplayed()) {
            this.driver.findElement(this.userLocator).sendKeys("qualityadmin");
            this.driver.findElement(this.passLocator).sendKeys("pass1");
            this.driver.findElement(this.registerBtnLocator).click();
            Thread.sleep(2000L);
            Assert.assertTrue(this.driver.findElement(this.homePageLocator).isDisplayed());
        } else {
            System.out.println("username textbox was bot present");
        }

    }
}
