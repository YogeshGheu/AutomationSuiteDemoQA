package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility extends BaseUtility{

    private static Actions getActions(){
        return new Actions(getDriver());
    }

    public static void moveToElement(WebElement element) {
        getActions().moveToElement(element).perform();
    }

    public static void pressKeys(String sequence){
        getActions().sendKeys(sequence);
    }

    public static void doubleClick(WebElement element){
        getActions().moveToElement(element).click().doubleClick(element).perform();
    }

    public static void rightClick(WebElement element){
        JavaScriptUtility.jsScroll(element);
        getActions().moveToElement(element).contextClick(element).perform();
    }
}
