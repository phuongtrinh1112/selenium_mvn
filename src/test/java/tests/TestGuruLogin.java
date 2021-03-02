package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GuruHomePageAfterLogin;
import pages.GuruLogin;

import java.util.Scanner;

public class TestGuruLogin {
    public static String baseUrl = "http://www.demo.guru99.com/v4/index.php";
    public static String accountName = "mngr304219";
    public static String accountPass = "haduqYm";

    public static WebDriver openWebsite() {
        System.setProperty("webdriver.chrome.driver", "..\\required_libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        return driver;
    }

    public static void testLogin() {
        int choice;
        do {
            System.out.println("Enter below option to run demo script for login Guru with each xpath type:");
            System.out.println("1. Xpath located by name");
            System.out.println("2. Xpath located by text user id and following");
            System.out.println("3. Xpath located by text password and following");
            System.out.println("4. Xpath located by attribute");
            System.out.println("5. Xpath located by self");
            System.out.println("6. Xpath located by contains");
            System.out.println("7. Xpath located by or");
            System.out.println("8. Xpath located by and");
            System.out.println("9. Xpath located by starts-with");
            System.out.println("0. Exit!");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    WebDriver firstDriver = openWebsite();
                    GuruLogin firstLogin = new GuruLogin(firstDriver);
                    firstLogin.login("Name", accountName, accountPass);
                    GuruHomePageAfterLogin afterFirstLogin = new GuruHomePageAfterLogin(firstDriver);
                    afterFirstLogin.checkLoginSuccessfully(accountName);
                    firstDriver.close();
                    break;
                case 2:
                    WebDriver secondDriver = openWebsite();
                    GuruLogin secondLogin = new GuruLogin(secondDriver);
                    secondLogin.login("Following UserId", accountName, accountPass);
                    GuruHomePageAfterLogin afterSecondLogin = new GuruHomePageAfterLogin(secondDriver);
                    afterSecondLogin.checkLoginSuccessfully(accountName);
                    secondDriver.close();
                    break;
                case 3:
                    WebDriver thirdDriver = openWebsite();
                    GuruLogin thirdLogin = new GuruLogin(thirdDriver);
                    thirdLogin.login("Following Password", accountName, accountPass);
                    GuruHomePageAfterLogin afterThirdLogin = new GuruHomePageAfterLogin(thirdDriver);
                    afterThirdLogin.checkLoginSuccessfully(accountName);
                    thirdDriver.close();
                    break;
                case 4:
                    WebDriver fourthDriver = openWebsite();
                    GuruLogin fourthLogin = new GuruLogin(fourthDriver);
                    fourthLogin.login("Attribute", accountName, accountPass);
                    GuruHomePageAfterLogin afterFourthLogin = new GuruHomePageAfterLogin(fourthDriver);
                    afterFourthLogin.checkLoginSuccessfully(accountName);
                    fourthDriver.close();
                    break;
                case 5:
                    WebDriver fifthDriver = openWebsite();
                    GuruLogin fifthLogin = new GuruLogin(fifthDriver);
                    fifthLogin.login("Self", accountName, accountPass);
                    GuruHomePageAfterLogin afterFifthLogin = new GuruHomePageAfterLogin(fifthDriver);
                    afterFifthLogin.checkLoginSuccessfully(accountName);
                    fifthDriver.close();
                    break;
                case 6:
                    WebDriver sixthDriver = openWebsite();
                    GuruLogin sixthLogin = new GuruLogin(sixthDriver);
                    sixthLogin.login("Contains", accountName, accountPass);
                    GuruHomePageAfterLogin afterSixthLogin = new GuruHomePageAfterLogin(sixthDriver);
                    afterSixthLogin.checkLoginSuccessfully(accountName);
                    sixthDriver.close();
                    break;
                case 7:
                    WebDriver seventhDriver = openWebsite();
                    GuruLogin seventhLogin = new GuruLogin(seventhDriver);
                    seventhLogin.login("Or", accountName, accountPass);
                    GuruHomePageAfterLogin afterSeventhLogin = new GuruHomePageAfterLogin(seventhDriver);
                    afterSeventhLogin.checkLoginSuccessfully(accountName);
                    seventhDriver.close();
                    break;
                case 8:
                    WebDriver eighthDriver = openWebsite();
                    GuruLogin eighthLogin = new GuruLogin(eighthDriver);
                    eighthLogin.login("And", accountName, accountPass);
                    GuruHomePageAfterLogin afterEighthLogin = new GuruHomePageAfterLogin(eighthDriver);
                    afterEighthLogin.checkLoginSuccessfully(accountName);
                    eighthDriver.close();
                    break;
                case 9:
                    WebDriver ninethDriver = openWebsite();
                    GuruLogin ninethLogin = new GuruLogin(ninethDriver);
                    ninethLogin.login("Starts With", accountName, accountPass);
                    GuruHomePageAfterLogin afterNinethLogin = new GuruHomePageAfterLogin(ninethDriver);
                    afterNinethLogin.checkLoginSuccessfully(accountName);
                    ninethDriver.close();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.exit(1);
                    break;
            }

        } while (choice != 0);
    }

    public static void main(String[] args) {
        testLogin();
    }
}
