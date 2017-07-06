import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 2/1/2017.
 */
public class CommunityFeed extends TestId{

    WebDriver driver;

    By poststab = By.cssSelector(testid("community-page__posts-tab"));
    By memberstab = By.cssSelector(testid("community-page__members-tab"));
    By resourcestab = By.cssSelector(testid("community-page__resources-tab"));

    By joinbutton = By.xpath("//*[@id='myDropdown']/button");
    By yesbutton = By.xpath("/html/body/div[2]/div/div/div[2]/button[2]");
    By gotitbutton = By.xpath("/html/body/app-layout/div/div[9]/div/div/div[2]/button");
    By optionsdropdown =  By.cssSelector(testid("community-org-banner__options-btn"));
    By leaveoption = By.xpath("//*[@id='myDropdown']/ul/li[3]/a");

    By communitypost1 = By.cssSelector(testid("post-communityfeed-0"));
    By communityposttitle1 = By.cssSelector(testid("post-communityfeed-title-0"));
    By communitypoststatement1 = By.cssSelector(testid("post-communityfeed-statement-0"));


    public CommunityFeed(WebDriver driver){

        this.driver = driver;
    }

    public void clickonjoinbutton(){

        driver.findElement(joinbutton).click();
    }

    public void clickonyesbutton(){

        driver.findElement(yesbutton).click();
    }

    public void clickongotitbutton(){

        driver.findElement(gotitbutton).click();
    }

    public void clickonoptionsdropdown(){

        driver.findElement(optionsdropdown).click();
    }

    public void clickonleaveoption(){

        driver.findElement(leaveoption).click();
    }

    public String getcommunitypostitle1(){

       String title =  driver.findElement(communityposttitle1).getText();

        return title;
    }




}



