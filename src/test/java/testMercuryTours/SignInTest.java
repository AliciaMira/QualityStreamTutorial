package testMercuryTours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.RegisterPage;
import pom.SignInPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInTest {
    private WebDriver driver;
    SignInPage signInPage;

    @Before
    public void setUp() throws Exception {
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit("http://demo.guru99.com/test/newtours");
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void test() throws Exception {
        signInPage.SignIn();
        Thread.sleep(2000);
        assertTrue(signInPage.isHomePageDisplayed());
    }
}