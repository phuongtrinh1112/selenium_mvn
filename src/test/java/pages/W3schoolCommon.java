package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class W3schoolCommon {
    WebDriver driver;
    public By xpathLeftMenuUnderAjax = By.xpath("//h2[@class='left' and text()='XML AJAX']//following::a[position() <= 10]");
    public By xpathW3schoolHome = By.xpath("//a[contains(text(), 'w3schools')]");
    public By xpathTopMenu = By.xpath("//a[contains(text(), 'w3schools')]//following::a[position() >=4 and position() <= 8]");
    public By xpathXmlLearning = By.xpath("//h3[text()='XML Tutorials']//ancestor::div[@class='w3-col l3 m6 w3-hide-medium']//a[position() <= 8]");

    Logger logger = Logger.getLogger(W3schoolCommon.class.getName());

    public W3schoolCommon(WebDriver driver){
        this.driver = driver;
    }

    public void clickALinkByIndex(List<WebElement> listElement, int linkIndex){
        listElement.get(linkIndex).click();
    }

    public List<WebElement> getElementList(By xpathValue){
        List<WebElement> elementList = this.driver.findElements(xpathValue);
        return elementList;
    }

    public boolean clickRandomLink(By xpathValue){
        List<WebElement> elements = getElementList(xpathValue);

        if( elements.size() > 0){
            int max = elements.size(), min = 0;
            int index = (int) ((Math.random() * (max - min)) + min);
            clickALinkByIndex(elements, index);
            return true;
        }
        else{
            logger.log(Level.INFO, "Not found any element to click");
            return false;
        }
    }

    public boolean backToHomePage(){
        List<WebElement> elements = this.driver.findElements(xpathW3schoolHome);
        if (elements.size() > 0){
            elements.get(0).click();
            return true;
        }
        else{
            logger.log(Level.INFO, "Not found any element to back home page");
            return false;
        }
    }

    public boolean clickALinkTopMenu(String name){
        List<WebElement> topMenu = getElementList(xpathTopMenu);
        if( topMenu.size() > 0){
            switch (name){
                case "TUTORIALS":
                    //topMenu.get(0).click();
                    clickALinkByIndex(topMenu,0);
                    return true;
                case "REFERENCES":
                    //topMenu.get(1).click();
                    clickALinkByIndex(topMenu,1);
                    return true;
                case "EXAMPLES":
                    //topMenu.get(2).click();
                    clickALinkByIndex(topMenu,2);
                    return true;
                case "EXERCISES":
                    //topMenu.get(3).click();
                    clickALinkByIndex(topMenu,3);
                    return true;
                case "CERTIFICATES":
                    //topMenu.get(4).click();
                    clickALinkByIndex(topMenu,4);
                    return true;
                default:
                    //topMenu.get(0).click();
                    clickALinkByIndex(topMenu,0);
                    return true;
            }
        }
        else{
            logger.log(Level.INFO, "Not found any element for top menu");
            return false;
        }
    }

    public void randomClickAnElement(By xpathValue){
        List<WebElement> elements = this.driver.findElements(xpathValue);
        if(elements.size() > 0){
            int max = elements.size(), min = 0;
            int index = (int) ((Math.random() * (max - min)) + min);

            //JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            //executeScript( javascript need to execute, argument). Argument can be WebElement, boolean, String, long, list
            // click method can not see the elements --> use javascriptExecutor to access those elements
            executor.executeScript("arguments[0].click();", elements.get(index));
        }
        else{
            logger.log(Level.INFO, "Can not find any element on navigation bar");
        }
    }

    public void clickRandomALinkOnLeftMenu(){
        List<WebElement> elements = getElementList(xpathLeftMenuUnderAjax);
        if(elements.size() > 0){
            for(int i = 0; i < elements.size(); i++){
                if(backToHomePage()){
                    if(clickALinkTopMenu("TUTORIALS")){
                        randomClickAnElement(xpathXmlLearning);
                        randomClickAnElement(xpathLeftMenuUnderAjax);
                    }
                    else {
                        logger.log(Level.INFO, "Can not click to any link on top menu");
                    }
                }
                else {
                    logger.log(Level.INFO,"Can not back to home page");
                }
                //wait 3 seconds for before reload page
                this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
    }
}
