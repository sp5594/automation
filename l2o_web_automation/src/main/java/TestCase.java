import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by shail on 1/19/2017.
 */
public class TestCase extends TestVariables {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){

        try {


            System.setProperty("webdriver.chrome.driver", "chromedriver");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //  driver.get("http://l2o.com");
            driver.get("http://webapp-dev-lwa.codewalla.com/home");

            wait = new WebDriverWait(driver, 10); //waits for 10 secs

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){

        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

     //   email_registration();
     //   logout();
        login();
     /*   resetonboardingscreens();

        posttohomecommunity("notanonymous");
        posttohomecommunity("anonymous");

        posttoonlyme("notanonymous");
        posttoonlyme("anonymous");

        posttoarandomcommunity("notanonymous");
        posttoarandomcommunity("anonymous");


       createapubliccommunity();
       createaprivatecommunity();
       createaninviteonlycommunity(); */

   //   joinacommunityfromcommunityfeedpage();
   //   joinacommunityfromcommunitypage();

      //  editprofile();

        logout();

        //resetpassword();


    }

    /**
     * <----------------------------------------------------------------------->
     * <--------------------------TEST CASE METHODS---------------------------->
     * <----------------------------------------------------------------------->
     */

    public void login(){

        LandingPage home = new LandingPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(home.login_email));
        home.setLogin_email(login_email);
        home.setLogin_password(login_password);
        home.clickonlogin();


        //verify method
        PostWidget post = new PostWidget(driver);

        verifymessage(post.postwidget, "Log In", "Log In");


    }

    public void logout(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.moremenu));
        header.clickonmoremenu();
        wait.until(ExpectedConditions.elementToBeClickable(header.logout));
        header.clickonlogout();

        //verify method
        LandingPage home = new LandingPage(driver);
        verifymessage(home.login_email, "Log Out", "Log Out");

    }


    public void email_registration(){

        LandingPage home = new LandingPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(home.firstname));
        home.setFirstname(firstname);
        home.setLastname(lastname);
        home.setRegister_email(register_email);
        home.setRegister_password(register_password);
        home.setrepeatpassword(repeatpassword);
        home.selectorganization(organization);
        home.clickoniam13yrsold();
        home.clickonsignup();

        Onboarding onboarding = new Onboarding(driver);
        wait.until(ExpectedConditions.elementToBeClickable(onboarding.myfeed_gotitbutton));
        onboarding.clickonmyfeedgotitbutton();

        gothroughonboardingscreens();

    }


    public void resetpassword(){

        LandingPage home = new LandingPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(home.resetpassword));
        home.clickonresetpassword();

        wait.until(ExpectedConditions.elementToBeClickable(home.resetpasswordemail));
        home.setresetpasswordemail("hey123zz@yahoo.com");

        wait.until(ExpectedConditions.elementToBeClickable(home.resetyourpasswordbutton));
        home.clickonresetyourpasswordbutton();

        wait.until(ExpectedConditions.elementToBeClickable(home.continuetologin));
        home.clickoncontinuetologin();

        verifymessage(home.login_email, "Password Reset", "Log In");

    }

    public void posttoonlyme(String anonymouscheck){

        filloutpostinfo();

        PostWidget post = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(post.recipientsbutton));
        post.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(post.onlymerecipient));
        post.clickononlymerecipient();
        wait.until(ExpectedConditions.elementToBeClickable(post.recipientsbutton));
        post.clickonrecipientsbutton();

        if(anonymouscheck.equals("anonymous")){

            wait.until(ExpectedConditions.elementToBeClickable(post.anonymousbutton));
            post.clickonanyonmousbutton();

        }

        wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
        post.clickonpostbutton();


        //verfies that you`re in the private journal
        Profile journal = new Profile(driver);
        wait.until(ExpectedConditions.elementToBeClickable(journal.onlymetab));

        //waits for the first post to be visible
        wait.until(ExpectedConditions.elementToBeClickable(journal.onlymepost1));

        //wait until first post is visible then compare post title to the given title
        Assert.assertEquals(posttitle, journal.getonlymepostitle1());

        gotohomepage();


    }

    public void posttoarandomcommunity(String anonymouscheck){

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

        wait.until(ExpectedConditions.elementToBeClickable(post.closepopup));
        post.clickonclosepopup();

        //verfies that you`re in the community feed
        CommunityFeed feed = new CommunityFeed(driver);
        wait.until(ExpectedConditions.elementToBeClickable(feed.poststab));

        //waits for the first post to be visible
        wait.until(ExpectedConditions.elementToBeClickable(feed.communitypost1));

        //wait until first post is visible then compare post title to the given title
        Assert.assertEquals(posttitle, feed.getcommunitypostitle1());

        gotohomepage();

    }

    public void posttohomecommunity(String anonymouscheck){

        filloutpostinfo();

        PostWidget post = new PostWidget(driver);

        if(anonymouscheck.equals("anonymous")){

            wait.until(ExpectedConditions.elementToBeClickable(post.anonymousbutton));
            post.clickonanyonmousbutton();

        }

        wait.until(ExpectedConditions.elementToBeClickable(post.postbutton));
        post.clickonpostbutton();

      //  driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(post.closepopup));
        post.clickonclosepopup();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(post.closepopupbackground));


        //verfies that you`re in the community feed
        CommunityFeed feed = new CommunityFeed(driver);
        wait.until(ExpectedConditions.elementToBeClickable(feed.poststab));

        //waits for the first post to be visible
        wait.until(ExpectedConditions.elementToBeClickable(feed.communitypost1));

        //wait until first post is visible then compare post title to the given title
        Assert.assertEquals(posttitle, feed.getcommunitypostitle1());

        gotohomepage();

    }



    public void createapubliccommunity(){

        gotocommunitypage();
        filloutrequiredcommunityinfo(publiccommunityname);
        clickoncreateacommunity();

        //check if you see members tab
        checkifyouseememberstab();

        //compare community title to given title


        gotohomepage();

    }

    public void createaprivatecommunity(){

        gotocommunitypage();
        filloutrequiredcommunityinfo(privatecommunityname);
        Communities communities = new Communities(driver);
        communities.clickonbasictab();
        communities.clickonprivateicon();
        clickoncreateacommunity();

        //check if you see members tab
        checkifyouseememberstab();

        //compare community title to given title

        gotohomepage();

    }

    public void createaninviteonlycommunity(){

        gotocommunitypage();
        filloutrequiredcommunityinfo(inviteonlycommunityname);
        Communities communities = new Communities(driver);
        communities.clickonaddmemberstab();
        wait.until(ExpectedConditions.elementToBeClickable(communities.searchfield));
        communities.searchforuser(searchname);
        wait.until(ExpectedConditions.elementToBeClickable(communities.addicon));
        communities.clickonaddicon();
        communities.clickonbasictab();
        communities.clickoninviteonlyicon();
        clickoncreateacommunity();

        //check if you see members tab
        checkifyouseememberstab();

        //compare community title to given title

        gotohomepage();

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

            String check = communities.getfirstmycommunityname();

            if(check.equals(browseallcommunitysearch)){

                System.out.println("Succesfully joined " + browseallcommunitysearch);
            }
            else{
                System.out.println("Unable to join " + browseallcommunitysearch);
            }

            gotohomepage();

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

            String check = communities.getfirstmycommunityname();

            if(check.equals(browseallcommunitysearch)){

                System.out.println("Succesfully joined " + browseallcommunitysearch);
            }
            else{
                System.out.println("Unable to join " + browseallcommunitysearch);
            }

            gotohomepage();

        }catch (Exception e){

            e.printStackTrace();
        }

    }

    public void leaveacommunity(){


        gotocommunitypage();
        gotomycommunities();
        searchforacommunity(browseallcommunitysearch);

        Communities communities = new Communities(driver);
        CommunityFeed communityfeed = new CommunityFeed(driver);
        try {
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communities.firstmycommunityresult));
            communities.clickonfirstmycommunityresult();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.optionsdropdown));
            communityfeed.clickonoptionsdropdown();
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.leaveoption));
            communityfeed.clickonleaveoption();
            wait.until(ExpectedConditions.elementToBeClickable(communityfeed.yesbutton));
            communityfeed.clickonyesbutton();

            clickonmycommunitiestab();
            searchforacommunity(browseallcommunitysearch);

         //   Thread.sleep(5000);


            gotohomepage();

        }catch (Exception e){

            e.printStackTrace();
        }




    }

    public void resetonboardingscreens(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.help));
        header.clickonhelp();

        wait.until(ExpectedConditions.elementToBeClickable(header.showtutorialsagain));
        header.clickonshowtutorialsagain();

        gothroughonboardingscreens();

    }

    public void editprofile(){

        gotoprofilepage();

        Profile profile = new Profile(driver);
        wait.until(ExpectedConditions.elementToBeClickable(profile.editprofilebutton));
        profile.clickoneditprofilebutton();

        EditProfile edit = new EditProfile(driver);
        wait.until(ExpectedConditions.elementToBeClickable(edit.firstname));
        edit.setFirstname(editfirstname);

        wait.until(ExpectedConditions.elementToBeClickable(edit.lastname));
        edit.setLastname(editlastname);

        wait.until(ExpectedConditions.elementToBeClickable(edit.location));
        edit.setLocation(editlocation);

        wait.until(ExpectedConditions.elementToBeClickable(edit.aboutmetab));
        edit.clickonaboutmetab();

        wait.until(ExpectedConditions.elementToBeClickable(edit.aboutmedescription));
        edit.setAboutmedescription(editaboutme);

        wait.until(ExpectedConditions.elementToBeClickable(edit.intereststab));
        edit.clickonintereststab();

        wait.until(ExpectedConditions.elementToBeClickable(edit.interest1));
        edit.select6interests();

        wait.until(ExpectedConditions.elementToBeClickable(edit.savebutton));
        edit.clickonsavebutton();

        wait.until(ExpectedConditions.elementToBeClickable(edit.cancelbutton));
        edit.clickoncancelbutton();

        wait.until(ExpectedConditions.elementToBeClickable(edit.gotitbutton));
        edit.clickongotitbutton();

        gotohomepage();

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

    public void checkifyouseememberstab(){

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.addmemberstab));

    }

    public void gotocommunitypage(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.communities));
        header.clickoncommunities();

    }

    public void gotoprofilepage(){

        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.profile));
        header.clickonprofile();

    }

    public void filloutrequiredcommunityinfo(String communityname){

        Communities communities = new Communities(driver);
        wait.until(ExpectedConditions.elementToBeClickable(communities.createacommunity));
        communities.clickoncreateacommunity();


        wait.until(ExpectedConditions.elementToBeClickable(communities.communityname));
        communities.setCommunityName(communityname);
        communities.setCommunityDescription(communitydescription);
        wait.until(ExpectedConditions.elementToBeClickable(communities.tagtab));
        communities.clickontagtab();
        wait.until(ExpectedConditions.elementToBeClickable(communities.tag1));
        communities.clickontags();

    }


    public void clickoncreateacommunity(){

        Communities communities = new Communities(driver);
        communities.clickoncreatebutton();
        wait.until(ExpectedConditions.elementToBeClickable(communities.gotit_button));
        communities.clickongotitbutton();

    }

    public void gotohomepage(){

        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        Header header = new Header(driver);
        wait.until(ExpectedConditions.elementToBeClickable(header.home));
        header.clickonhome();

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

        try{

        Thread.sleep(3000);

        PostWidget post = new PostWidget(driver);

        wait.until(ExpectedConditions.elementToBeClickable(post.postwidget));
        post.clickonpostwidget();

        wait.until(ExpectedConditions.elementToBeClickable(post.posttitle));
        post.setposttitle(posttitle);

        wait.until(ExpectedConditions.elementToBeClickable(post.postbody));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(post.postbody));
        actions.click();
        actions.sendKeys(postbodytext);
        actions.build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(post.tagsicon));
        post.clickontagsicon();

        wait.until(ExpectedConditions.elementToBeClickable(post.tags_icon1));
        post.select6tags();

        wait.until(ExpectedConditions.elementToBeClickable(post.tagsicon));
        post.clickontagsicon();

        }catch (Exception e){

            e.printStackTrace();
        }


    }



    public Boolean iselementdisplayed(By by){

        Boolean isPresent = driver.findElements(by).size() != 0;

        return isPresent;
    }


    public void verifymessage(By by, String message1, String message2){


            try{

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                Boolean isPresent = driver.findElements(by).size() != 0;

                Assert.assertTrue(isPresent);

                System.out.println(message1 + " - Passed");

            }catch(AssertionError e){

                System.out.println(message1 + " - Failed");

                throw e;
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

    public void gothroughonboardingscreens(){


        Onboarding onboarding = new Onboarding(driver);

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.myfeed_nextbutton));
        onboarding.clickonmyfeednextbutton();

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.myfeed_nextbutton));
        onboarding.clickonmyfeednextbutton();

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.myfeed_gotitbutton));
        onboarding.clickonmyfeedgotitbutton();

        PostWidget widget = new PostWidget(driver);
        wait.until(ExpectedConditions.elementToBeClickable(widget.postwidget));
        widget.clickonpostwidget();
        wait.until(ExpectedConditions.elementToBeClickable(widget.anonymousbutton));
        widget.clickonanyonmousbutton();
        wait.until(ExpectedConditions.elementToBeClickable(onboarding.anonymous_gotitbutton));
        onboarding.clickonanonymousgotitbutton();

        wait.until(ExpectedConditions.elementToBeClickable(widget.recipientsbutton));
        widget.clickonrecipientsbutton();
        wait.until(ExpectedConditions.elementToBeClickable(onboarding.recipients_gotitbutton));
        onboarding.clickonrecipientsgotitbutton();

        gotocommunitypage();

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.communities_gotitbutton));
        onboarding.clickoncommunitiesgotitbutton();

        gotoprofilepage();

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.profile_nextbutton));
        onboarding.clickonprofilenextbutton();

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.profile_nextbutton));
        onboarding.clickonprofilenextbutton();

        wait.until(ExpectedConditions.elementToBeClickable(onboarding.profile_gotitbutton));
        onboarding.clickonprofilegotitbutton();

        //need to add aha onboarding
        
        gotohomepage();

    }


}
