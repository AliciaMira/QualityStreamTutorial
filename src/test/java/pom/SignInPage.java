package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");
    By homePageLocator = By.xpath("//h3[contains(text(), 'Login Successfully')]");

   public void SignIn(){
       if (isDisplayed(userLocator)){
           type("qualityadmin", userLocator);
           type("pass1", passLocator );
           click(signInBtnLocator);
       }else{
           System.out.println("username textbox was not present");
       }
   }

   public Boolean isHomePageDisplayed(){
       return isDisplayed(homePageLocator);
   }
}
