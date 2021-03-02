package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuruLogin {
     Logger logger = Logger.getLogger(GuruLogin.class.getName());

    public By userIdXpathByName = By.xpath("//input[@name='uid']");
    public By passwordXpathByName = By.xpath("//input[@name='password']");
    public By loginBtnXpathByName = By.xpath("//input[@name='btnLogin']");

    public By userIdXpathByFollowingOfUserId = By.xpath("//td[contains(text(),'UserID')]//following::td[1]/input");
    public By passwordXpathByFollowingOfUserId = By.xpath("//td[contains(text(),'UserID')]//following::td[3]/input");
    public By loginBtnXpathByFollowingOfUserId = By.xpath("//td[contains(text(),'UserID')]//following::td[5]/input");

    public By userIdXpathByFollowingOfPassword = By.xpath("//td[contains(text(),'Password')]//preceding::input");
    public By passwordXpathByFollowingOfPassword = By.xpath("//td[contains(text(),'Password')]//following::td[1]/input");
    public By loginBtnXpathByFollowingOfPassword = By.xpath("//td[contains(text(),'Password')]//following::td[3]/input");

    public By userIdXpathByAtrribute = By.xpath("//input[@type='text']");
    public By passwordXpathByAtrribute = By.xpath("//input[@type='password']");
    public By loginBtnXpathByAtrribute = By.xpath("//*[@type='submit']");

    public By userIdXpathBySelf = By.xpath("//self::input[@type='text']");
    public By passwordXpathBySelf = By.xpath("//self::input[@type='password']");
    public By loginBtnXpathBySelf = By.xpath("//self::input[@type='submit']");

    public By loginBtnXpathByContains = By.xpath("//self::input[@type='submit']");
    public By loginBtnXpathByOr = By.xpath("//self::input[@type='submit']");
    public By loginBtnXpathByAnd = By.xpath("//self::input[@type='submit']");
    public By loginBtnXpathByStartWith = By.xpath("//self::input[@type='submit']");

    WebDriver driver;

    public GuruLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void setInput(By xpathValue, String text) {
        List<WebElement> elements = driver.findElements(xpathValue);
        if (elements.size() > 0) {
            elements.get(0).sendKeys(text);
        } else {
            logger.log(Level.INFO, "Not found any element!");
        }
    }

    public void clickButton(By xpathValue) {
        List<WebElement> elements = driver.findElements(xpathValue);
        if (elements.size() > 0) {
            elements.get(0).click();
        } else {
            logger.setLevel(Level.INFO);
            logger.log(Level.INFO, "Not found any element!");
        }
    }

    public void setUserIdByType(String xpathType, String text) {
        switch (xpathType) {
            case "Name":
                setInput(userIdXpathByName, text);
                break;
            case "Following UserId":
                setInput(userIdXpathByFollowingOfUserId, text);
                break;
            case "Following Password":
                setInput(userIdXpathByFollowingOfPassword, text);
                break;
            case "Attribute":
                setInput(userIdXpathByAtrribute, text);
                break;
            case "Self":
                setInput(userIdXpathBySelf, text);
                break;
            default:
                setInput(userIdXpathByName, text);
                break;
        }
    }

    public void setPasswordByType(String xpathType, String text) {
        switch (xpathType) {
            case "Name":
                setInput(passwordXpathByName, text);
                break;
            case "Following UserId":
                setInput(passwordXpathByFollowingOfUserId, text);
                break;
            case "Following Password":
                setInput(passwordXpathByFollowingOfPassword, text);
                break;
            case "Attribute":
                setInput(passwordXpathByAtrribute, text);
                break;
            case "Self":
                setInput(passwordXpathBySelf, text);
                break;
            default:
                setInput(passwordXpathByName, text);
                break;
        }
    }

    public void clickLoginBtnByType(String xpathType) {
        switch (xpathType) {
            case "Name":
                clickButton(loginBtnXpathByName);
                break;
            case "Following UserId":
                clickButton(loginBtnXpathByFollowingOfUserId);
                break;
            case "Following Password":
                clickButton(loginBtnXpathByFollowingOfPassword);
                break;
            case "Attribute":
                clickButton(loginBtnXpathByAtrribute);
                break;
            case "Self":
                clickButton(loginBtnXpathBySelf);
                break;
            case "Contains":
                clickButton(loginBtnXpathByContains);
                break;
            case "Or":
                clickButton(loginBtnXpathByOr);
                break;
            case "And":
                clickButton(loginBtnXpathByAnd);
                break;
            case "Starts With":
                clickButton(loginBtnXpathByStartWith);
                break;
        }
    }

    public void login(String xpathType, String userName, String password){
        setUserIdByType(xpathType, userName);
        setPasswordByType(xpathType, password);
        clickLoginBtnByType(xpathType);
    }
}
