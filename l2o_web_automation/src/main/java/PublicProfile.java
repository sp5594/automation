import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 7/6/17.
 */
public class PublicProfile extends TestId {

    WebDriver driver;

    By follow_unfollow_button = By.cssSelector(testid("public-journal__follow-unfollow-button"));
    By message_button = By.cssSelector("");
    By post = By.cssSelector("journal-page__posts-tab");
    By yesoption = By.className("btn-primary");



    public PublicProfile(WebDriver driver){

        this.driver = driver;
    }

    public void clickonefollowunfollowbutton(){

        driver.findElement(follow_unfollow_button).click();
    }

    public void clickonyesoption(){

        driver.findElement(yesoption).click();
    }
}
