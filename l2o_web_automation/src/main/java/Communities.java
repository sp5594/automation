import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 1/24/2017.
 */
public class Communities {

    WebDriver driver;

    By createacommunity = By.xpath("//*[@id='panel-scroll-x']/div[3]/div/button");
    By waitforcommunitiestoload = By.xpath("/html/body/app-layout/div/section/ui-view/div/div[3]");

    By browsecommunitiestab = By.xpath("/html/body/app-layout/div/section/ui-view/div/div[1]/div/div[2]/div/a[2]");
    By mycommunitiestab = By.xpath("/html/body/app-layout/div/section/ui-view/div/div[1]/div/div[2]/div/a[1]");

    By communityname = By.id("communityName");
    By communitydescription = By.id("desc");
    By publicicon = By.xpath("//*[@id='basicInfo']/div/div[4]/ul/li[1]/a/span[1]");
    By privateicon = By.xpath("//*[@id='basicInfo']/div/div[4]/ul/li[2]/a/span[1]");
    By inviteonlyicon = By.xpath("//*[@id='basicInfo']/div/div[4]/ul/li[3]/a/span[1]");
    By imageicon = By.xpath("//*[@id='basicInfo']/div/div[3]/div[1]/div[2]/div[1]");

    By basictab = By.id("basicInfoCommunity");
    By tagtab = By.xpath("//*[@id='mobileHeight']/li[2]/a[1]");
    By addmemberstab = By.id("add-members");

    By tag1 = By.xpath("//*[@id='scrollbarTags']/div/ul/li[1]");
    By tag2 = By.xpath("//*[@id='scrollbarTags']/div/ul/li[2]");
    By tag3 = By.xpath("//*[@id='scrollbarTags']/div/ul/li[3]");
    By tag4 = By.xpath("//*[@id='scrollbarTags']/div/ul/li[4]");
    By tag5 = By.xpath("//*[@id='scrollbarTags']/div/ul/li[5]");
    By tag6 = By.xpath("//*[@id='scrollbarTags']/div/ul/li[6]");

    By searchfield = By.xpath("//*[@id='addMembers']/div[1]/div[1]/div/input");
    By addicon = By.xpath("//*[@id='addMembers']/div[1]/div[2]/div[2]/div[1]/span[3]/img");

    By create_button = By.id("create-community-btn");
    By gotit_button = By.xpath("/html/body/app-layout/div/div[9]/div/div/div[2]/button");

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


}
