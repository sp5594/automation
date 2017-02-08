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
    By onlymepostbutton = By.xpath("//*[@id='10879']/div/div/div[5]/div/div/button");

    By tagsicon = By.xpath("//*[@id='myFeedCreatePost']/ng-include/div/div[2]/div/div/div/div[2]/button");
    By tagslist = By.xpath("//*[@id='postToCategories']");
    By tagsicon1 = By.xpath("//*[@id='scrollbarTags']/div[2]/ul/li[1]/i");
    By anonymousbutton = By.xpath("//*[@id='myFeedCreatePost']/ng-include/div/div[2]/div/div/div/div[3]/div[2]/ul/li/div/label");

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

    public void select6tags(){

        for(int i = 1; i <= 6; i++){

            driver.findElement(By.xpath("//*[@id='scrollbarTags']/div[2]/ul/li[" + i + "]/i")).click();

        }
    }

    public void clickontagsicon(){

        driver.findElement(tagsicon).click();
    }

    public void clickonanyonmousbutton(){

        driver.findElement(anonymousbutton).click();
    }

    public void clickonclosepopup(){

        driver.findElement(closepopup).click();

    }


    public void clickononlymepostbutton(){

        driver.findElement(onlymepostbutton).click();

    }


}
