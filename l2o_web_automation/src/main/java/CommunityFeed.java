import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 2/1/2017.
 */
public class CommunityFeed {

    WebDriver driver;

    By poststab = By.xpath("//*[@id='learningCommunityTab']");

    public CommunityFeed(WebDriver driver){

        this.driver = driver;
    }

}



