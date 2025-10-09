package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility extends BaseUtility{

    public static void moveToElement(By locator) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(locator)).perform();
    }
}
