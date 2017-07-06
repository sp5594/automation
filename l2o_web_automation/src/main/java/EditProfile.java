import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 6/23/17.
 */
public class EditProfile extends TestId  {

    WebDriver driver;

    By basicinformationtab = By.cssSelector(testid("edit-profile__basic-info-tab"));
    By aboutmetab = By.cssSelector(testid("edit-profile__about-me-tab"));
    By intereststab = By.cssSelector(testid("edit-profile__interest-tab"));

    By firstname = By.cssSelector(testid("edit-profile__first-name"));
    By lastname = By.cssSelector(testid("edit-profile__last-name"));
    By location = By.cssSelector(testid("edit-profile__location"));
    By aboutmedescription = By.cssSelector(testid("edit-profile__about-me"));
    By interest1 = By.cssSelector(testid("edit-profile__interest-0"));
    By interest2 = By.cssSelector(testid("edit-profile__interest-1"));
    By interest3 = By.cssSelector(testid("edit-profile__interest-2"));
    By interest4 = By.cssSelector(testid("edit-profile__interest-3"));
    By interest5 = By.cssSelector(testid("edit-profile__interest-4"));
    By interest6 = By.cssSelector(testid("edit-profile__interest-5"));

    By addlinkedinbutton = By.cssSelector(testid("edit-profile__add-linkedin-profile-btn"));
    By savebutton = By.cssSelector(testid("edit-profile__save-btn--interest-tab"));
    By cancelbutton = By.cssSelector(testid("edit-profile__cancel-btn--interest-tab"));

    By gotitbutton = By.className("close-growl");


    public EditProfile(WebDriver driver){

        this.driver = driver;
    }

    public void clickonbasicinfotab(){

        driver.findElement(basicinformationtab).click();
    }

    public void clickonaboutmetab(){

        driver.findElement(aboutmetab).click();
    }

    public void clickonintereststab(){

        driver.findElement(intereststab).click();
    }

    public void setFirstname(String fname){

        driver.findElement(firstname).clear();
        driver.findElement(firstname).sendKeys(fname);
    }

    public void setLastname(String lname){

        driver.findElement(lastname).clear();
        driver.findElement(lastname).sendKeys(lname);
    }

    public void setLocation(String address){

        driver.findElement(location).clear();
        driver.findElement(location).sendKeys(address);
    }

    public void setAboutmedescription(String description){

        driver.findElement(aboutmedescription).clear();
        driver.findElement(aboutmedescription).sendKeys(description);
    }

    public void select6interests(){

        driver.findElement(interest1).click();
        driver.findElement(interest2).click();
        driver.findElement(interest3).click();
        driver.findElement(interest4).click();
        driver.findElement(interest5).click();
        driver.findElement(interest6).click();

    }

    public void clickonaddlinkedinbutton(){

        driver.findElement(addlinkedinbutton).click();
    }

    public void clickoncancelbutton(){

        driver.findElement(cancelbutton).click();
    }

    public void clickonsavebutton(){

        driver.findElement(savebutton).click();
    }

    public void clickongotitbutton(){

        driver.findElement(gotitbutton).click();
    }
}
