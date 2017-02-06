package l2oweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 2/1/2017.
 */
public class PrivateJournal {

    WebDriver driver;

    By onlymetab =  By.xpath("//*[@id='JournalTabs']/a[2]");

    public PrivateJournal(WebDriver driver){

        this.driver = driver;
    }
}
