import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 2/1/2017.
 */
public class CommunityFeed {

    WebDriver driver;

    By poststab = By.xpath("//*[@id='learningCommunityTab']");
    By joinbutton = By.xpath("//*[@id='myDropdown']/button");
    By yesbutton = By.xpath("/html/body/div[2]/div/div/div[2]/button[2]");
    By gotitbutton = By.xpath("/html/body/app-layout/div/div[9]/div/div/div[2]/button");


    public CommunityFeed(WebDriver driver){

        this.driver = driver;
    }

    public void clickonjoinbutton(){

        driver.findElement(joinbutton).click();
    }

    public void clickonyesbutton(){

        driver.findElement(yesbutton).click();
    }

    public void clickongotitbutton(){

        driver.findElement(gotitbutton).click();
    }

}



