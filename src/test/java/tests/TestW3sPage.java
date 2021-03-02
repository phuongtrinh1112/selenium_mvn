package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.W3schoolCommon;

public class TestW3sPage {
    public static String baseUrl = "https://www.w3schools.com/xml/ajax_xmlfile.asp";
    public static WebDriver openWebsite(){
        System.setProperty("webdriver.chrome.driver", "..\\required_libs\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
        return webDriver;
    }

    public static void leftMenuUnderAjax() {
        WebDriver driver = openWebsite();
        W3schoolCommon w3schoolCommon = new W3schoolCommon(driver);
        w3schoolCommon.clickRandomALinkOnLeftMenu();
        driver.close();
    }

    public static void main(String[] args) {
        leftMenuUnderAjax();
    }
}
