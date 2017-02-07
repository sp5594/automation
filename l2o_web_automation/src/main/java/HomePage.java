import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 1/23/2017.
 */
public class HomePage {

    WebDriver driver;

    By login_email = By.id("email");
    By login_password = By.id("pwd");
    By login = By.id("loginmain");

    By firstname = By.id("first_name");
    By lastname = By.id("last_name");
    By register_email = By.id("emailAddFB");
    By register_password = By.id("passwordSignup");
    By repeatpassword = By.id("password_confirmation");
    By check13yrsold = By.xpath("//*[@id='signupForm']/form/div[6]/label[1]/label");
    By signup = By.className("signupBtn");
    By emailverificationmodal = By.id("emailVerificationModal");

   public HomePage(WebDriver driver){

       this.driver = driver;
   }

   public void setLogin_email(String emailvalue){

       driver.findElement(login_email).sendKeys(emailvalue);
   }

    public void setLogin_password(String passwordvalue){

        driver.findElement(login_password).sendKeys(passwordvalue);
    }

    public void clickonlogin(){

        driver.findElement(login).click();
    }

    public void setFirstname(String firstnamevalue){

        driver.findElement(firstname).sendKeys(firstnamevalue);
    }

    public void setLastname(String lastnamevalue){

        driver.findElement(lastname).sendKeys(lastnamevalue);
    }

    public void setRegister_email(String emailvalue){

        driver.findElement(register_email).sendKeys(emailvalue);
    }

    public void setRegister_password(String passwordvalue){

        driver.findElement(register_password).sendKeys(passwordvalue);
    }

    public void setrepeatpassword(String passwordvalue){

        driver.findElement(repeatpassword).sendKeys(passwordvalue);
    }

    public void clickoniam13yrsold(){

        driver.findElement(check13yrsold).click();
    }

    public void clickonsignup(){

        driver.findElement(signup).click();
    }

}
