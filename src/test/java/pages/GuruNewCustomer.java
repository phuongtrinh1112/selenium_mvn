package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuruNewCustomer {
    WebDriver driver;
    public By xpathCustomerName = By.xpath("//input[@name='name']");
    public By xpathCustomerGender = By.xpath("//input[@type='radio']");
    public By xpathCustomerDob = By.xpath("//input[@type='date']");
    public By xpathCustomerAddress = By.xpath("//textarea[@name='addr']");
    public By xpathCustomerCity = By.xpath("//input[@name='city']");
    public By xpathCustomerState = By.xpath("//input[@name='state']");
    public By xpathCustomerPin = By.xpath("//input[@name='pinno']");
    public By xpathCustomerPhone = By.xpath("//input[@name='telephoneno']");
    public By xpathCustomerEmail = By.xpath("//input[@name='emailid']");
    public By xpathCustomerPass = By.xpath("//input[@name='password']");
    public By xpathCustomerSubmitBtn = By.xpath("//input[@type='submit']");
    public Logger logger = Logger.getLogger(GuruNewCustomer.class.getName());

    public GuruNewCustomer(WebDriver driver){
        this.driver = driver;
    }
    public String generateRandomName(int length){
        String alphabet = "ABCDEFGHIKLMNOPRSTWYVXQZ";
        StringBuilder randomTxt = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++){
            int index = random.nextInt(alphabet.length());
            char randomLetter = alphabet.charAt(index);
            randomTxt.append(randomLetter);
        }
        return  randomTxt.toString();
    }

    public int generateRandomNumber(int uperBoundary){
        Random random = new Random();
        return  random.nextInt(uperBoundary);
    }

    public int generateRandomNumberInRange(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String generateRandomDateInText(){
        String dd = String.valueOf(generateRandomNumber(28));
        String mm = String.valueOf(generateRandomNumber(12));
        String yyyy = String.valueOf(generateRandomNumberInRange(1966,1995));

        return dd + mm + yyyy;
    }

    public void buttonClick(By xpath){
        List<WebElement> elements = driver.findElements(xpath);
        if( elements.size() > 0){
            elements.get(0).click();
        }else{
            logger.log(Level.INFO, "Not find any element to click!");
        }
    }

    public void radioClick(By xpath){
        List<WebElement> elements = driver.findElements(xpath);
        if( elements.size() > 0){
            int index = generateRandomNumberInRange(1, elements.size());
            elements.get(index).click();
        }else{
            logger.log(Level.INFO, "Not find any element to click!");
        }
    }

    public <T> void setTextBoxValue(By xpath, T value){
        List<WebElement> elements = driver.findElements(xpath);
        if( elements.size() > 0){
            elements.get(0).sendKeys(String.valueOf(value));
        }else{
            logger.log(Level.INFO, "Not find any elelement to insert text!");
        }
    }

    public String createNewCustomer(){
        //input value for each element
        String customerName = generateRandomName(10);
        setTextBoxValue(xpathCustomerName, customerName);
        setTextBoxValue(xpathCustomerDob, generateRandomDateInText());
        radioClick(xpathCustomerGender);
        setTextBoxValue(xpathCustomerAddress, generateRandomName(20));
        setTextBoxValue(xpathCustomerCity, generateRandomName(6));
        setTextBoxValue(xpathCustomerState, generateRandomName(6) );
        setTextBoxValue(xpathCustomerPin, generateRandomNumberInRange(100000,9999999));
        setTextBoxValue(xpathCustomerPhone, generateRandomNumber(300));
        setTextBoxValue(xpathCustomerEmail, generateRandomName(6) + "@gmail.com");
        setTextBoxValue(xpathCustomerPass, generateRandomName(6));

        //click create button
        buttonClick(xpathCustomerSubmitBtn);
        return customerName;
    }
}
