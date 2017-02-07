import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 1/31/2017.
 */
public class PostWidget {

    WebDriver driver;

    //post elements
    By postwidget = By.id("ilearnedText");
    By posttitle = By.id("learning_title");
    By postbody = By.xpath("//*[@id='ephox_textboxCreateLearning']/div/div[4]");
    By postbutton = By.id("postLearning");

    By recipientsbutton = By.xpath("//*[@id='myFeedCreatePost']/ng-include/div/div[2]/div/div/div/div[3]/div[1]/a/span[4]");
    By publicrecipient = By.id("publicSelected");
    By onlymerecipient = By.id("onlyMeSelected");
    By communitiesrecipient = By.id("communitiesSelected");
    By firstcommunityrecipient = By.xpath("//*[@id='crtLerCommList']/div/div/ul/li[1]");


    By closepopup = By.xpath("//*[@id='shareSocial']/div/a");

    public PostWidget(WebDriver driver){

        this.driver = driver;
    }

    public void clickonpostwidget(){

        driver.findElement(postwidget).click();

    }

    public void setposttitle(String title){

        driver.findElement(posttitle).sendKeys(title);
    }

    public void clickonpostbutton(){

        driver.findElement(postbutton).click();

    }

    public void clickonrecipientsbutton(){

        driver.findElement(recipientsbutton).click();

    }

    public void clickonpublicrecipient(){

        driver.findElement(publicrecipient).click();

    }

    public void clickononlymerecipient(){

        driver.findElement(onlymerecipient).click();

    }

    public void clickoncommunitiesrecipient(){

        driver.findElement(communitiesrecipient).click();

    }

    public void clickonfirstcommunityrecipient(){

        driver.findElement(firstcommunityrecipient).click();

    }



    public void clickonclosepopup(){

        driver.findElement(closepopup).click();

    }


}
