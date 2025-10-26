package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility extends BaseUtility{

    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public static void pressKeys(String sequence){
        Actions actions = new Actions(getDriver());
        actions.sendKeys(sequence);
    }
}
