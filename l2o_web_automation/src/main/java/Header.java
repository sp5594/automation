import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 1/24/2017.
 */
public class Header {

    WebDriver driver;

    By myfeed = By.className("learning-feed-menu");
    By communities = By.className("communities-menu");
    By moremenu = By.xpath("/html/body/app-layout/div/div[1]/header/nav[1]/div/div/ul/li[9]");
    By logout = By.xpath("//*[@id='dropDownMenuHeader']/li[4]");


    public Header(WebDriver driver){

        this.driver = driver;
    }

    public void clickonmyfeed(){

        driver.findElement(myfeed).click();
    }

    public void clickoncommunities(){

        driver.findElement(communities).click();
    }

    public void clickonmoremenu(){

        driver.findElement(moremenu).click();
    }

    public void clickonlogout(){

        driver.findElement(logout).click();
    }

}




