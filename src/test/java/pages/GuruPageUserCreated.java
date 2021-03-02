package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuruPageUserCreated {
    WebDriver driver;
    public By xpathUserCreated = By.xpath("//table[@name='customer']//tr[5]//td[2]");
    Logger logger = Logger.getLogger(GuruPageUserCreated.class.getName());

    public GuruPageUserCreated(WebDriver driver){
        this.driver = driver;
    }

    public void verifyUserCreated(String userName){
        List<WebElement> elements = this.driver.findElements(xpathUserCreated);
        if( elements.size() > 0){
            if ( elements.get(0).getText().contains(userName)){
                logger.log(Level.INFO, "User is created successfully");
            }
            else{
                logger.log(Level.INFO, "User is created failed");
            }
        }else {
            logger.log(Level.INFO, "Not found any element!");
        }
    }
}
