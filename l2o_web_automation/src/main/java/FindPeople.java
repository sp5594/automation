import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 7/6/17.
 */
public class FindPeople extends TestId {

    WebDriver driver;

    By sendinvitation = By.cssSelector(testid("find-people__send-invitations"));
    By addanotherperson = By.cssSelector(testid("find-people__add-another-person"));
    By sendinvite = By.cssSelector(testid("find-people__modal-send-invitations"));
    By closeinvitemodal = By.cssSelector(testid("find-people__close-invite-modal-button"));
    By gotitbutton = By.className("close-growl");

    By searchmembers = By.cssSelector(testid("find-people__search-members-input"));
    By searchresultuser1 = By.cssSelector(testid("find-people__search-result-0"));
    By searchresultfollow1 = By.cssSelector(testid("find-people__search-result-user-follow-0"));
    By searchresultunfollow1 = By.cssSelector(testid("find-people__search-result-user-unfollow-0"));


    public FindPeople(WebDriver driver){

        this.driver = driver;
    }

    public void clickonsendinvitation(){

        driver.findElement(sendinvitation).click();
    }

    public void clickonaddanotherperson(){

        driver.findElement(addanotherperson).click();
    }

    public void inviteinfo(int totalnumberofinvites, String[] email, String[] firstname, String[] lastname){

        for(int i = 0; i < totalnumberofinvites; i++){

            driver.findElement(By.cssSelector(testid("find-people__invite-email-" + i))).sendKeys(email[i]);
            driver.findElement(By.cssSelector(testid("find-people__invite-fname-" + i))).sendKeys(firstname[i]);
            driver.findElement(By.cssSelector(testid("find-people__invite-lname-" + i))).sendKeys(lastname[i]);

            clickonaddanotherperson();
        }


    }

    public void clickonsendinvite(){

        driver.findElement(sendinvite).click();
    }

    public void clickongotitbutton(){

        driver.findElement(gotitbutton).click();
    }

    public void clickoncloseinvitemodalbutton(){

        driver.findElement(closeinvitemodal).click();
    }

    public void searchforauser(String username){

        driver.findElement(searchmembers).sendKeys(username);

    }

    public void clickonfirstuser(){

        driver.findElement(searchresultuser1).click();

    }

    public void clickonfirstuserfollowbutton(){

        driver.findElement(searchresultfollow1).click();

    }

    public void clickonfirstuserunfollowbutton(){

        driver.findElement(searchresultunfollow1).click();

    }




}
