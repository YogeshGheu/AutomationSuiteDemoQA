package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {

    WebDriver driver;
    Actions actions;


    public ActionsUtility(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void moveToElement(By locator) {
        actions.moveToElement(driver.findElement(locator)).perform();
    }
}
