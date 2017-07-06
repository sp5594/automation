import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 6/20/17.
 */
public class Onboarding extends TestId {

    WebDriver driver;

    By joincommunity1 = By.cssSelector(testid("onboarding-my-feed__suggested-community-btn-0"));
    By myfeed_gotitbutton = By.cssSelector(testid("onboarding-my-feed__got-it-btn"));
    By myfeed_nextbutton = By.cssSelector(testid("onboarding-my-feed__next-btn"));

    By anonymous_gotitbutton = By.cssSelector(testid("onboarding-anonymous__got-it-btn"));
    By recipients_gotitbutton = By.cssSelector(testid("onboarding-recipients__got-it-btn"));

    By communities_gotitbutton = By.cssSelector(testid("onboarding-communities__got-it-btn"));

    By profile_nextbutton = By.cssSelector(testid("onboarding-journal__next-btn"));
    By profile_gotitbutton = By.cssSelector(testid("onboarding-journal__got-it-btn"));



    public Onboarding(WebDriver driver){

        this.driver = driver;
    }

    public void clickonjoincommunitybutton1(){

        driver.findElement(joincommunity1).click();
    }

    public void clickonmyfeedgotitbutton(){

        driver.findElement(myfeed_gotitbutton).click();
    }

    public void clickonmyfeednextbutton(){

        driver.findElement(myfeed_nextbutton).click();
    }

    public void clickonanonymousgotitbutton(){

        driver.findElement(anonymous_gotitbutton).click();
    }

    public void clickonrecipientsgotitbutton(){

        driver.findElement(recipients_gotitbutton).click();
    }

    public void clickoncommunitiesgotitbutton(){

        driver.findElement(communities_gotitbutton).click();
    }

    public void clickonprofilegotitbutton(){

        driver.findElement(profile_gotitbutton).click();
    }

    public void clickonprofilenextbutton(){

        driver.findElement(profile_nextbutton).click();
    }
}
