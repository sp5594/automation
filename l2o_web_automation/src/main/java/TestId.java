import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 6/13/17.
 */
public class TestId {

    public String testid(String value) {

        String totalstring = "[data-test-id='" + value + "']";

        return totalstring;

    }
}
