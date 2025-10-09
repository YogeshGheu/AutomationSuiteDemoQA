package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionsUtility;
import utilities.BaseUtility;
import utilities.JavaScriptUtility;
import utilities.WaitUtility;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        BaseUtility.setUtilityDriver(driver);
    }

    public WebElement find(By locator) {
        WaitUtility.waitForElementToBeVisible(locator);
        return driver.findElement(locator);
    }

    public void click(By locator) {
        try {
            ActionsUtility.moveToElement(locator);
            find(locator).click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Error occurred while clicking, trying javascript click ! " + e.getMessage());
            JavaScriptUtility.jsClick(find(locator));
        }
    }

    public List<WebElement> findAll(By locator) {
        WaitUtility.waitForElementToBeVisible(locator);
        return driver.findElements(locator);
    }

    public void sendKeys(By locator, String text) {
        find(locator).sendKeys(text);
    }

}
