import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


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

      joinacommunityfromcommunityfeedpage();
      //  joinacommunityfromcommunitypage();


        //searchforamycommunity();
        // searchforabrowseallcommunity();

     // searchforamycommunity();
  /*
      createapublicpost("notanonymous");
      createapublicpost("anonymous");

      createanonlymepost("notanonymous");
      createanonlymepost("anonymous");

      createacommunitypost("notanonymous");
      createacommunitypost("anonymous");

      createapublicandcommunitypost("notanonymous");
      createapublicandcommunitypost("anonymous");


      createapubliccommunity();
      createaprivatecommunity();
      createainviteonlycommunity();
*/
   //   logout();

   //   email_registration();


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

        //verify method
        PostWidget post = new PostWidget(driver);
        Boolean bool = verifymethod(post.postwidget);
        verifymessage(bool, "Successfully Logged In", "Failed to Log In");

    }

    public void logout(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.moremenu));
        header.clickonmoremenu();
        header.clickonlogout();

        //verify method
        HomePage home = new HomePage(driver);
        Boolean bool = verifymethod(home.login_email);
        verifymessage(bool, "Successfully Logged Out", "Failed to Log Out");

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

    public void createapublicpost(String anonymouscheck){

        filloutpostinfo();
        PostWidget post = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(post.recipientsbutton));
        post.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.publicrecipient));
        post.clickonpublicrecipient();
        if(anonymouscheck.equals("anonymous")){

            wait.until(ExpectedConditions.elementToBeClickable(post.anonymousbutton));
            post.clickonanyonmousbutton();

        }
        wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
        post.clickonpostbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.closepopup));
        post.clickonclosepopup();

        gotocommunitypage();


        //verfies that you`re in my feed
        Boolean bool = verifymethod(post.postwidget);
        if(anonymouscheck.equals("anonymous")){

            verifymessage(bool, "Anonymous Post has been posted to public recipients",
                                "Anonymous Post has NOT been posted to public recipients");

        }else
        {

            verifymessage(bool, "Post has been posted to public recipients",
                    "Post has NOT been posted to public recipients");

        }



    }


    public void createanonlymepost(String anonymouscheck){

        filloutpostinfo();
        PostWidget post = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(post.recipientsbutton));
        post.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.onlymerecipient));
        post.clickononlymerecipient();
        wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
        post.clickonpostbutton();

        gotomyfeed();

        //verfies that you`re in the private journal
        PrivateJournal journal = new PrivateJournal(driver);
        //wait.until(ExpectedConditions.elementToBeClickable(journal.onlymetab));
        //verfies that you`re in my feed
        Boolean bool = verifymethod(journal.onlymetab);
        verifymessage(bool, "Post is saved as an only me post",
                    "Post is saved as an only me post");


        //click on the post button
     //   wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
     //   post.clickonpostbutton();

        gotomyfeed();




    }

    public void createacommunitypost(String anonymouscheck){

        filloutpostinfo();
        PostWidget post = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(post.recipientsbutton));
        post.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.communitiesrecipient));
        post.clickoncommunitiesrecipient();
        wait.until(ExpectedConditions.elementToBeClickable(post.firstcommunityrecipient));
        post.clickonfirstcommunityrecipient();
        if(anonymouscheck.equals("anonymous")){

            wait.until(ExpectedConditions.elementToBeClickable(post.anonymousbutton));
            post.clickonanyonmousbutton();

        }
        wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
        post.clickonpostbutton();

        //verfies that you`re in the community feed
        CommunityFeed feed = new CommunityFeed(driver);
        wait.until(ExpectedConditions.elementToBeClickable(feed.poststab));

        gotomyfeed();

    }

    public void createapublicandcommunitypost(String anonymouscheck){

        filloutpostinfo();
        PostWidget post = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(post.recipientsbutton));
        post.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.publicrecipient));
        post.clickonpublicrecipient();
        wait.until(ExpectedConditions.elementToBeClickable(post.communitiesrecipient));
        post.clickoncommunitiesrecipient();
        wait.until(ExpectedConditions.elementToBeClickable(post.firstcommunityrecipient));
        post.clickonfirstcommunityrecipient();
        if(anonymouscheck.equals("anonymous")){

            wait.until(ExpectedConditions.elementToBeClickable(post.anonymousbutton));
            post.clickonanyonmousbutton();

        }
        wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
        post.clickonpostbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.closepopup));
        post.clickonclosepopup();

        //verfies that you`re on the public feed
        wait.until(ExpectedConditions.elementToBeClickable(post.postwidget));

    }


    public void createapubliccommunity(){

        gotocommunitypage();
        filloutcommunityinfo(publiccommunityname);
        createbuttonthread();
        checkifyouseethelearningwidget();
        gotomyfeed();

    }

    public void createaprivatecommunity(){

        gotocommunitypage();
        filloutcommunityinfo(privatecommunityname);
        Communities communities = new Communities(driver);
        communities.clickonbasictab();
        communities.clickonprivateicon();
        createbuttonthread();
        checkifyouseethelearningwidget();
        gotomyfeed();

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
        gotomyfeed();

    }

    public void joinacommunityfromcommunitypage(){

        gotocommunitypage();
        clickonbrowseallcommunitiestab();
        searchforacommunity(browseallcommunitysearch);

        Communities communities = new Communities(driver);
        CommunityFeed communityfeed = new CommunityFeed(driver);
        try {
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communities.firstbrowsecommunityresult));
            // join
            communities.clickonjoinbutton();
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.gotitbutton));
            communityfeed.clickongotitbutton();
            clickonmycommunitiestab();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communities.firstmycommunityresult));

            String check = communities.getfirstbrowsecommunityname();

            if(check.equals(browseallcommunitysearch)){

                System.out.println("Succesfully joined " + browseallcommunitysearch);
            }
            else{
                System.out.println("Unable to join " + browseallcommunitysearch);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

    }

    public void joinacommunityfromcommunityfeedpage(){

        gotocommunitypage();
        clickonbrowseallcommunitiestab();
        searchforacommunity(browseallcommunitysearch);

        Communities communities = new Communities(driver);
        CommunityFeed communityfeed = new CommunityFeed(driver);
        try {
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communities.firstbrowsecommunityresult));
            communities.clickonfirstbrowsecommunityresult();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.joinbutton));
            communityfeed.clickonjoinbutton();
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.yesbutton));
            communityfeed.clickonyesbutton();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.gotitbutton));
            communityfeed.clickongotitbutton();
            gotocommunitypage();
            clickonmycommunitiestab();
            searchforacommunity(browseallcommunitysearch);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communities.firstmycommunityresult));

            String check = communities.getfirstbrowsecommunityname();

            if(check.equals(browseallcommunitysearch)){

                System.out.println("Succesfully joined " + browseallcommunitysearch);
            }
            else{
                System.out.println("Unable to join " + browseallcommunitysearch);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

    }




    /**
     * <----------------------------------------------------------------------->
     * <-----------------------OOP RE-USABLE METHODS--------------------------->
     * <----------------------------------------------------------------------->
     */

    public void checkifyouseethelearningwidget(){

        PostWidget post = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(post.postwidget));

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
            PostWidget post = new PostWidget(driver);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(post.postwidget));
            post.clickonpostwidget();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(post.posttitle));
            post.setposttitle(posttitle);
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(post.postbody));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='ephox_textboxCreateLearning']/div/div[4]")));;
            actions.click();
            actions.sendKeys(postbodytext);
            actions.build().perform();
            post.clickontagsicon();
            post.select6tags();
            post.clickontagsicon();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(post.tagslist));
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


    public boolean verifymethod(By by){

        boolean value;

        try{

            Thread.sleep(5000);
            driver.findElement(by);

            return true;

        } catch(Exception e){

            return false;
        }

    }

    public void verifymessage(Boolean bool, String message1, String message2){

        String verify = bool.toString();
        if(verify.equals("true")){

            System.out.println(message1);

        }else if(verify.equals("false")){

            System.out.println(message2);

        }

    }

    public void searchforacommunity(String communityname){

    //    gotocommunitypage();
        Communities communities = new Communities(driver);
      //  wait.until(ExpectedConditions.elementToBeClickable(communities.mycommunitiestab));
     //   communities.clickonmycommunities();
        wait.until(ExpectedConditions.elementToBeClickable(communities.searchcommunityfield));
        communities.searchforacommunity(communityname);

    }

    public void clickonmycommunitiestab(){

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.mycommunitiestab));
        communities.clickonmycommunities();
    }

    public void clickonbrowseallcommunitiestab(){

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.browsecommunitiestab));
        communities.clickonbrowsecommunities();
    }







}
