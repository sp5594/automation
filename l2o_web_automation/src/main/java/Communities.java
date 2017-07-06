import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by shail on 1/24/2017.
 */
public class Communities extends TestId{

    WebDriver driver;

    By createacommunity = By.cssSelector(testid("communities__create-community-btn"));
    By waitforcommunitiestoload = By.cssSelector(testid("communities__create-community-btn"));

    By browsecommunitiestab = By.cssSelector(testid("communities__browse-tab"));
    By mycommunitiestab = By.cssSelector(testid("communities__my-communities-tab"));
    By searchcommunityfield = By.cssSelector(testid("communities__create-community-btn"));
    By firstmycommunityresult = By.cssSelector(testid("communities__my-community-0"));
    By firstbrowsecommunityresult = By.cssSelector(testid("communities__my-community-0"));
    By getfirstmycommunityname = By.cssSelector(testid("communities__my-community-name-0"));


    By communityname = By.id("communityName");
    By communitydescription = By.id("desc");
    By publicicon = By.cssSelector(testid("create-community__public-privacy"));
    By privateicon = By.cssSelector(testid("create-community__private-privacy"));
    By inviteonlyicon = By.cssSelector(testid("create-community__invite-privacy"));
    By imageicon = By.cssSelector(testid("create-community__image-btn"));

    By basictab = By.cssSelector(testid("create-community__basic-info-tab"));
    By tagtab = By.cssSelector(testid("create-community__tag-tab"));
    By addmemberstab = By.cssSelector(testid("create-community__members-tab"));
    By coverphototab = By.cssSelector(testid("create-community__cover-photo-tab"));
    By settingstab = By.cssSelector(testid("create-community__settings-tab"));


    By tag1 = By.cssSelector(testid("create-community__tag-0"));
    By tag2 = By.cssSelector(testid("create-community__tag-1"));
    By tag3 = By.cssSelector(testid("create-community__tag-2"));
    By tag4 = By.cssSelector(testid("create-community__tag-3"));
    By tag5 = By.cssSelector(testid("create-community__tag-4"));
    By tag6 = By.cssSelector(testid("create-community__tag-5"));

    By searchfield = By.cssSelector(testid("create-community__search-members-input"));
    By addicon = By.cssSelector(testid("create-community__user-add-0"));

    By create_button = By.id("create-community-btn");
    By gotit_button = By.className("close-growl");
    By join_button = By.cssSelector(testid("communities__create-community-btn"));

    public Communities(WebDriver driver){

        this.driver = driver;
    }

    public void clickoncreateacommunity(){

        driver.findElement(createacommunity).click();
    }

    public void clickonmycommunities(){

        driver.findElement(mycommunitiestab).click();
    }

    public void clickonbrowsecommunities(){

        driver.findElement(browsecommunitiestab).click();
    }


    public void searchforacommunity(String communitynamevalue){

        driver.findElement(searchcommunityfield).sendKeys(communitynamevalue);
    }

    public void clickonfirstmycommunityresult(){

        driver.findElement(firstmycommunityresult).click();
    }

    public void clickonfirstbrowsecommunityresult(){

        driver.findElement(firstbrowsecommunityresult).click();
    }

    public String getfirstmycommunityname(){

      String name = driver.findElement(getfirstmycommunityname).getText();

      return name;
    }



    public void setCommunityName(String communitynamevalue){

        driver.findElement(communityname).sendKeys(communitynamevalue);
    }

    public void setCommunityDescription(String communitydescriptionvalue){

        driver.findElement(communitydescription).sendKeys(communitydescriptionvalue);
    }

    public void addImage(){

        driver.findElement(imageicon).click();
    }

    public void clickonpublicicon(){

        driver.findElement(publicicon).click();
    }

    public void clickonprivateicon(){

        driver.findElement(privateicon).click();
    }

    public void clickoninviteonlyicon(){

        driver.findElement(inviteonlyicon).click();
    }

    public void clickonbasictab(){

        driver.findElement(basictab).click();
    }

    public void clickonaddmemberstab(){

        driver.findElement(addmemberstab).click();
    }

    public void clickontagtab(){

        driver.findElement(tagtab).click();
    }

    public void clickontags(){

        driver.findElement(tag1).click();
        driver.findElement(tag2).click();
        driver.findElement(tag3).click();
        driver.findElement(tag4).click();
        driver.findElement(tag5).click();
        driver.findElement(tag6).click();

    }

    public void clickoncreatebutton(){

        driver.findElement(create_button).click();

    }

    public void clickongotitbutton(){

        driver.findElement(gotit_button).click();

    }

    public void searchforuser(String username){

        driver.findElement(searchfield).sendKeys(username);

    }

    public void clickonaddicon(){

        driver.findElement(addicon).click();

    }

    public void clickonjoinbutton(){

        driver.findElement(join_button).click();

    }



}
