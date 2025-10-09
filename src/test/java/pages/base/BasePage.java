package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import utilities.ActionsUtility;
import utilities.JavaScriptUtility;
import utilities.WaitUtility;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    WaitUtility waitUtility;
    ActionsUtility actionsUtility;
    JavaScriptUtility javaScriptUtility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitUtility = new WaitUtility(driver);
        actionsUtility = new ActionsUtility(driver);
        javaScriptUtility = new JavaScriptUtility(driver);
    }

    public WebElement find(By locator) {
        waitUtility.waitForElementToBeVisible(locator);
        return driver.findElement(locator);
    }

    public void click(By locator) {
        try {
            actionsUtility.moveToElement(locator);
            find(locator).click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Error occurred while clicking, trying javascript click ! " + e.getMessage());
            javaScriptUtility.jsClick(find(locator));
        }
    }

    public List<WebElement> findAll(By locator) {
        waitUtility.waitForElementToBeVisible(locator);
        return driver.findElements(locator);
    }

    public void sendKeys(By locator, String text) {
        find(locator).sendKeys(text);
    }

}
