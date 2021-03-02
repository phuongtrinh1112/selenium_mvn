package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GuruCommon {
    public By leftMenuXpath = By.xpath("//h2[contains(text(), 'Guru99 Bank')]//following::a");
    WebDriver driver;
    List<WebElement> listLeftMenu;

    public GuruCommon(WebDriver driver) {
        this.driver = driver;
        this.listLeftMenu = this.driver.findElements(leftMenuXpath);
    }

    public void clickOnALinkByIndex(List<WebElement> list, int index) {
        list.get(index).click();
    }

    public void clickOnLeftMenuLink(String text) {
        switch (text) {
            case "Manager":
                clickOnALinkByIndex(listLeftMenu, 0);
                break;
            case "New Customer":
                clickOnALinkByIndex(listLeftMenu, 1);
                break;
            case "Edit Customer":
                clickOnALinkByIndex(listLeftMenu, 2);
                break;
            case "Delete Customer":
                clickOnALinkByIndex(listLeftMenu, 3);
                break;
            case "New Account":
                clickOnALinkByIndex(listLeftMenu, 4);
                break;
            case "Edit Account":
                clickOnALinkByIndex(listLeftMenu, 5);
                break;
            case "Delete Account":
                clickOnALinkByIndex(listLeftMenu, 6);
                break;
            case "Deposit":
                clickOnALinkByIndex(listLeftMenu, 7);
                break;
            case "Withdrawal":
                clickOnALinkByIndex(listLeftMenu, 8);
                break;
            case "Fund Transfer":
                clickOnALinkByIndex(listLeftMenu, 9);
                break;
            case "Change Password":
                clickOnALinkByIndex(listLeftMenu, 10);
                break;
            case "Balance Enquiry":
                clickOnALinkByIndex(listLeftMenu, 11);
                break;
            case "Mini Statement":
                clickOnALinkByIndex(listLeftMenu, 12);
                break;
            case "Customised Statement":
                clickOnALinkByIndex(listLeftMenu, 13);
                break;
            case "Log out":
                clickOnALinkByIndex(listLeftMenu, 14);
                break;
            default:
                clickOnALinkByIndex(listLeftMenu, 0);
                break;
        }
    }

}
