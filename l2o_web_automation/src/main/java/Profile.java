import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 2/1/2017.
 */
public class Profile extends TestId {

    WebDriver driver;

    By editprofilebutton = By.cssSelector(testid("edit-profile-btn"));
    By poststab = By.cssSelector(testid("journal-page__posts-tab"));
    By onlymetab = By.cssSelector(testid("journal-page__only-me-tab"));
    By kepttab = By.cssSelector(testid("journal-page__kept-tab"));
    By buildstab = By.cssSelector(testid("journal-page__builds-tab"));

    By onlymepost1 = By.cssSelector(testid("post--0"));
    By onlymeposttitle1 = By.cssSelector(testid("post--title-0"));
    By onlymepoststatement1 = By.cssSelector(testid("post--statement-0"));


    public Profile(WebDriver driver){

        this.driver = driver;
    }

    public void clickoneditprofilebutton(){

        driver.findElement(editprofilebutton).click();
    }

    public String getonlymepostitle1(){

        String title =  driver.findElement(onlymeposttitle1).getText();

        return title;
    }
}
