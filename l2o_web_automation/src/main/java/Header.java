import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 1/24/2017.
 */
public class Header extends TestId{

    WebDriver driver;

    By home = By.cssSelector(testid("app-header__home-btn"));
    By communities = By.cssSelector(testid("app-header__communities-btn"));
    By profile = By.cssSelector(testid("app-header__profile-btn"));
    By findpeople = By.cssSelector(testid("app-header__find-people-btn"));
    By help = By.cssSelector(testid("app-header__help-btn"));
    By showtutorialsagain = By.cssSelector(testid("app-header__show-tutorials-btn"));
    By moremenu = By.cssSelector(testid("app-header__more-menu-btn"));
    By settings = By.cssSelector(testid("app-header__settings-btn"));
    By logout = By.cssSelector(testid("app-header__log-out-btn"));


    public Header(WebDriver driver){

        this.driver = driver;
    }

    public void clickonhome(){

        driver.findElement(home).click();
    }

    public void clickoncommunities(){

        driver.findElement(communities).click();
    }

    public void clickonprofile(){

        driver.findElement(profile).click();
    }

    public void clickonfindpeople(){

        driver.findElement(findpeople).click();
    }

    public void clickonhelp(){

        driver.findElement(help).click();
    }

    public void clickonshowtutorialsagain(){

        driver.findElement(showtutorialsagain).click();
    }

    public void clickonmoremenu(){

        driver.findElement(moremenu).click();
    }

    public void clickonsettings(){

        driver.findElement(settings).click();
    }


    public void clickonlogout(){

        driver.findElement(logout).click();
    }

}




