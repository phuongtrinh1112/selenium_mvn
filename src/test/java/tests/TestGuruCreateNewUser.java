package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestGuruCreateNewUser {
    public static String baseUrl = "http://www.demo.guru99.com/v4/index.php";
    public static String accountName = "mngr304219";
    public static String accountPass = "haduqYm";
    public static Logger logger = Logger.getLogger(TestGuruCreateNewUser.class.getName());

    public static WebDriver openWebsite() {
        System.setProperty("webdriver.chrome.driver", "..\\..\\..\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        return driver;
    }

    public static void createNewUserFlow(){
        WebDriver driver = openWebsite();
        //login
        GuruLogin guruLogin = new GuruLogin(driver);
        guruLogin.login("Name", accountName, accountPass);
        //verify home page after login
        GuruHomePageAfterLogin pageAfterLogin = new GuruHomePageAfterLogin(driver);
        if (pageAfterLogin.checkLoginSuccessfully(accountName)){
            //click new customer button on left menu
            GuruCommon guruCommon = new GuruCommon(driver);
            guruCommon.clickOnLeftMenuLink("New Customer");
            //create new customer
            GuruNewCustomer guruNewCustomer = new GuruNewCustomer(driver);
            String customerName = guruNewCustomer.createNewCustomer();
            //check user is created
            GuruPageUserCreated guruPageUserCreated = new GuruPageUserCreated(driver);
            guruPageUserCreated.verifyUserCreated(customerName);
        }
        else{
            logger.log(Level.INFO, "Not login successfully. Not do any further action!");
        }
        driver.close();
    }

    public static void main(String[] args) {
        createNewUserFlow();
    }
}
