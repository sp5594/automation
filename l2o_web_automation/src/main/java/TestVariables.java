import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shail on 1/23/2017.
 */
public class TestVariables{

    //login
    String login_email = "hey123zz@yahoo.com";
    String login_password = "lol123";

    //register
    String firstname = "Test";
    String lastname = "Test";
    String register_email = "test103443ds@testing.com";
    String register_password = "L2o123456";
    String repeatpassword = "L2o123456";
    String organization = "7889";

    //create a community
    String publiccommunityname = "RandomCommunityName_" + random7digits();
    String privatecommunityname = "RandomCommunityName_" + random7digits();
    String inviteonlycommunityname = "RandomCommunityName_" + random7digits();
    String communitydescription = "This community was creating using Selenium Framework";
    String searchname = "shail";
    String image = "C:\\Users\\shail\\Desktop\\testimage.png";

    //search a community
    String mycommunitysearch = "Banks";
    String browseallcommunitysearch = "65354";

    //create a learning
    String posttitle = "Automation Test";
    String postbodytext =  "Test Automated Post. This post was created using Selenium Automation Framework";

    //Edit profile
    String editfirstname = randomfirstname();
    String editlastname = randomlastname();
    String editlocation = "NY";
    String editaboutme = "test123";

    //Invite
    int totalinvites = 3;
    String [] inviteemails = {"dssds@yahoo.com", "sdsdsd@yahoo.com","eeewweew@yahoo.com"};
    String [] invitefirstnames = {"Jane", "Andy","Richard"};
    String [] invitelastnames = {"Smith", "Jones","White"};

    //Random Generator Methods
    public static String random7digits()
    {

        String randomnumber;

        int[] intArray = new int[7];

        for (int i = 0; i <= 6; i++) {

            intArray[i] = randnumbermethod();
        }

        randomnumber = Arrays.toString(intArray).replaceAll("\\[|\\]|,|\\s", "");

        return randomnumber;

    }

    public static int randnumbermethod() {

        int num = 0;

        int min = 2;
        int max = 9;

        Random random = new Random();
        int randomNum  = (random.nextInt(max - min + 1) + min);
        // System.out.print(randomNum);
        num = randomNum;
        return num;

    }


    public static String randomfirstname() {

        String[] firstnames = {"Sophia","Jackson", "Emma",	"Aiden", "Olivia",	"Lucas", "Ava",
                "Liam", "Mia",	"Noah", "Isabella","Ethan", "Riley","Mason", "Aria", "Caden", "Zoe",
                "Oliver", "Charlotte", "Elijah", "Lily","Grayson","Layla",	"Jacob",};

        Random random = new java.util.Random();
        int random_number = random.nextInt(firstnames.length);
        String randomname =  firstnames[random_number];

        return randomname;
    }

    public static String randomlastname() {

        String[] lastnames = {"Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
                "Anderson", "Thomas", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez"};
        Random random = new java.util.Random();
        int random_number = random.nextInt(lastnames.length);
        String randomname = lastnames[random_number];

        return randomname;
    }

    public String randommessage() {

        String[] messages = {"Hello", "How are you?", "I`m good, thanks!", "Sure I`ll help you"};

        Random random = new java.util.Random();
        int random_message = random.nextInt(messages.length);
        String randommessage =  messages[random_message];

        return randommessage;
    }




}

