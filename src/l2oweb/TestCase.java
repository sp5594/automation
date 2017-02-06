package l2oweb;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by shail on 1/19/2017.
 */
public class
TestCase extends TestVariables {

    WebDriver driver;
    WebDriverWait wait;


    @Test
    public void test(){

        System.setProperty("webdriver.chrome.driver", "chromedriver");

       driver = new ChromeDriver();
       driver.manage().window().maximize();
     //  driver.get("http://l2o.com");
      driver.get("http://webapp-stg-lwa.codewalla.com/home");

       wait = new WebDriverWait(driver, 20); //waits for 10 secs


      login();

      createapublicpost();
      createanonlymepost();
      createacommunitypost();
      createapubliccommunity();
      createaprivatecommunity();
      createainviteonlycommunity();

      logout();

      email_registration();


    }

    /**
     * <----------------------------------------------------------------------->
     * <--------------------------TEST CASE METHODS---------------------------->
     * <----------------------------------------------------------------------->
     */

    public void login(){

        HomePage home = new HomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(home.login_email));
        home.setLogin_email(login_email);
        home.setLogin_password(login_password);
        home.clickonlogin();

       checkifyouseethelearningwidget();
    }

    public void logout(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.moremenu));
        header.clickonmoremenu();
        header.clickonlogout();

        HomePage home = new HomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(home.login_email));

    }

    public void email_registration(){

        HomePage home = new HomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(home.firstname));
        home.setFirstname(firstname);
        home.setLastname(lastname);
        home.setRegister_email(register_email);
        home.setRegister_password(register_password);
        home.setrepeatpassword(repeatpassword);
        home.clickoniam13yrsold();
        home.clickonsignup();

        wait.until(ExpectedConditions.elementToBeClickable(home.emailverificationmodal));

    }

    public void createapublicpost(){

        filloutpostinfo();
        PostWidget commonelement = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.recipientsbutton));
        commonelement.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.publicrecipient));
        commonelement.clickonpublicrecipient();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.postbutton));
        commonelement.clickonpostbutton();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.closepopup));
        commonelement.clickonclosepopup();

        //verfies that you`re on the public feed
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.postwidget));


    }

    public void createanonlymepost(){

        filloutpostinfo();
        PostWidget commonelement = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.recipientsbutton));
        commonelement.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.onlymerecipient));
        commonelement.clickononlymerecipient();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.postbutton));
        commonelement.clickonpostbutton();

        //verfies that you`re in the private journal
        PrivateJournal journal = new PrivateJournal(driver);
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.onlymerecipient));

        gotomyfeed();

    }

    public void createacommunitypost(){

        filloutpostinfo();
        PostWidget commonelement = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.recipientsbutton));
        commonelement.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.communitiesrecipient));
        commonelement.clickoncommunitiesrecipient();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.firstcommunityrecipient));
        commonelement.clickonfirstcommunityrecipient();
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.postbutton));
        commonelement.clickonpostbutton();

        //verfies that you`re in the community feed
        CommunityFeed feed = new CommunityFeed(driver);
        wait.until(ExpectedConditions.elementToBeClickable(feed.poststab));

        gotomyfeed();

    }


    public void createapubliccommunity(){

        gotocommunitypage();
        filloutcommunityinfo(publiccommunityname);
        createbuttonthread();
        checkifyouseethelearningwidget();

    }

    public void createaprivatecommunity(){

        gotocommunitypage();
        filloutcommunityinfo(privatecommunityname);
        Communities communities = new Communities(driver);
        communities.clickonbasictab();
        communities.clickonprivateicon();
        createbuttonthread();
        checkifyouseethelearningwidget();

    }

    public void createainviteonlycommunity(){

        gotocommunitypage();
        filloutcommunityinfo(inviteonlycommunityname);
        Communities communities = new Communities(driver);
        communities.clickonaddmemberstab();
        wait.until(ExpectedConditions.elementToBeClickable(communities.searchfield));
        communities.searchforuser(searchname);
        wait.until(ExpectedConditions.elementToBeClickable(communities.addicon));
        communities.clickonaddicon();
        communities.clickonbasictab();
        communities.clickoninviteonlyicon();
        createbuttonthread();
        checkifyouseethelearningwidget();

    }



    /**
     * <----------------------------------------------------------------------->
     * <-----------------------OOP RE-USABLE METHODS--------------------------->
     * <----------------------------------------------------------------------->
     */

    public void checkifyouseethelearningwidget(){

        PostWidget commonelement = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(commonelement.postwidget));
    }

    public void gotocommunitypage(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.communities));
        header.clickoncommunities();

    }


    public void filloutcommunityinfo(String communityname){

        try {

            Communities communities = new Communities(driver);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communities.createacommunity));
            communities.clickoncreateacommunity();

        } catch (Exception e){
            e.printStackTrace();
        }

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.communityname));
        communities.setCommunityName(communityname);
        communities.setCommunityDescription(communitydescription);
        wait.until(ExpectedConditions.elementToBeClickable(communities.tagtab));
        communities.clickontagtab();
        wait.until(ExpectedConditions.elementToBeClickable(communities.tag1));
        communities.clickontags();

    }


    public void createbuttonthread(){

        Communities communities = new Communities(driver);
        try {

            Thread.sleep(5000);

            communities.clickoncreatebutton();

        } catch (Exception e){
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(communities.gotit_button));
        communities.clickongotitbutton();

    }

    public void gotomycommunities(){

        gotocommunitypage();

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.mycommunitiestab));
        communities.clickonmycommunities();

    }


    public void gotobrowsecommunities(){

        gotocommunitypage();

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.browsecommunitiestab));
        communities.clickonbrowsecommunities();

    }

    public void filloutpostinfo(){

        try {
            PostWidget commonelement = new PostWidget(driver);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(commonelement.postwidget));
            commonelement.clickonpostwidget();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(commonelement.posttitle));
            commonelement.setposttitle(posttitle);
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(commonelement.postbody));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='ephox_textboxCreateLearning']/div/div[4]")));;
            actions.click();
            actions.sendKeys(postbodytext);
            actions.build().perform();
            }catch (Exception e){

            e.printStackTrace();
        }

    }

    public void gotomyfeed(){

        try {
            Header header = new Header(driver);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(header.myfeed));
            header.clickonmyfeed();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
