import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by shail on 1/23/2017.
 */
public class LandingPage extends TestId {

    WebDriver driver;


    By login_email = By.cssSelector(testid("login-form__email"));
    By login_password = By.cssSelector(testid("login-form__password"));
    By login = By.cssSelector(testid("login-form__login-btn"));

    By firstname = By.cssSelector(testid("signup-form__first-name"));
    By lastname = By.cssSelector(testid("signup-form__last-name"));
    By register_email = By.cssSelector(testid("signup-form__email"));
    By register_password = By.cssSelector(testid("signup-form__password"));
    By repeatpassword = By.cssSelector(testid("signup-form__password-confirmation"));
    By organization = By.cssSelector(testid("signup-form__org"));
    By check13yrsold = By.cssSelector(testid("signup-form__age-confirmation-label"));
    By signup = By.cssSelector(testid("signup-form__signup-btn"));
    By emailverificationmodal = By.id("emailVerificationModal");

    By resetpassword = By.cssSelector(testid("login-form__forgot-password-btn"));
    By resetpasswordemail = By.cssSelector(testid("password-reset-form__email"));
    By resetyourpasswordbutton = By.cssSelector(testid("password-reset-form__submit-btn"));
    By continuetologin = By.cssSelector(testid("password-reset-modal__continue-btn"));

   public LandingPage(WebDriver driver){

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

    public void selectorganization(String orgname){

        Select select = new Select(driver.findElement(organization));
        select.selectByValue("string:" + orgname);
    }

    public void clickoniam13yrsold(){

        driver.findElement(check13yrsold).click();
    }

    public void clickonsignup(){

        driver.findElement(signup).click();
    }

    public void clickonresetpassword(){

        driver.findElement(resetpassword).click();
    }

    public void setresetpasswordemail(String resetemail){

        driver.findElement(resetpasswordemail).clear();
        driver.findElement(resetpasswordemail).sendKeys(resetemail);
    }

    public void clickonresetyourpasswordbutton(){

        driver.findElement(resetyourpasswordbutton).click();
    }

    public void clickoncontinuetologin(){

        driver.findElement(continuetologin).click();
    }


    // check methods

    public boolean isloginfieldvisible(){

        try{

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(login_email);

            return true;
        }
        catch(NoSuchElementException e){

            return false;
        }
    }


}
