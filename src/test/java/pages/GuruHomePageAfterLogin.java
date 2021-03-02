package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuruHomePageAfterLogin {
    WebDriver driver;
    //public String accountName;
    //public By xpathLoginSuccessFully = By.xpath("//td[contains(text(),'" + this.accountName + "')]");
    public By xpathLoginSuccessFully = By.xpath("//tr[@class='heading3']/td");
    Logger logger = Logger.getLogger(GuruHomePageAfterLogin.class.getName());

    public GuruHomePageAfterLogin(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkLoginSuccessfully(String accountName){
        //this.accountName = accountName;
        //System.out.println("Account name: " + accountName);
        List<WebElement> elements = driver.findElements(xpathLoginSuccessFully);
        //System.out.printf("XPATH: " + xpathLoginSuccessFully);
        if( elements.size() > 0 ){
            String actualAccountName = elements.get(0).getText();
            if (actualAccountName.contains(accountName)){
                logger.log(Level.INFO, "LOGGIN SUCCESSFULLY!");
                return true;
            }
            else{
                logger.log(Level.INFO, "LOGIN FAILED!");
                return false;
            }
        }
        else{
            logger.log(Level.INFO, "LOGIN FAILED!");
            return false;
        }
    }
}
