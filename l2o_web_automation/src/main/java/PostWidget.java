import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Created by shail on 1/31/2017.
 */
public class PostWidget extends  TestId{

    WebDriver driver;

    //post elements
    By postwidget = By.cssSelector(testid("home-create-learning__button-prompt"));
    By posttitle = By.cssSelector(testid("learning-form__learning-title"));
    By postbody = By.className("ephox-polish-socket");
    By postbutton = By.cssSelector(testid("learning-form-buttons__save-btn"));
    By anonymousbutton = By.className("onoffswitch");
    //By.id("myonoffswitch_post");

    By tagsicon = By.cssSelector(testid("form-tag-select__tag-btn"));
    By tags_icon1 = By.cssSelector(testid("form-tag__category-0"));
    By tags_icon2 = By.cssSelector(testid("form-tag__category-1"));
    By tags_icon3 = By.cssSelector(testid("form-tag__category-2"));
    By tags_icon4 = By.cssSelector(testid("form-tag__category-3"));
    By tags_icon5 = By.cssSelector(testid("form-tag__category-4"));
    By tags_icon6 = By.cssSelector(testid("form-tag__category-5"));



    By recipientsbutton = By.cssSelector(testid("recipient-select__dropdown-header"));
    By onlymerecipient = By.cssSelector(testid("recipient-select__onlyme-selector"));
    By communitiesrecipient = By.cssSelector(testid("recipient-select__communities-selector"));
    By firstcommunityrecipient = By.cssSelector(testid("recipient-select__community-1"));


    By closepopup = By.cssSelector(testid("share-social-media-modal__close-btn"));
    By closepopupbackground = By.className("fade");

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

        driver.findElement(tags_icon1).click();
        driver.findElement(tags_icon2).click();
        driver.findElement(tags_icon3).click();
        driver.findElement(tags_icon4).click();
        driver.findElement(tags_icon5).click();
        driver.findElement(tags_icon6).click();

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






}
