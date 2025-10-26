package pages.base;

import org.openqa.selenium.*;
import utilities.ActionsUtility;
import utilities.BaseUtility;
import utilities.JavaScriptUtility;
import utilities.WaitUtility;

import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        BaseUtility.setUtilityDriver(driver);
    }

    public WebElement find(By locator) {
        try{
            return driver.findElement(locator);
        }catch (TimeoutException e){
            return WaitUtility.waitForElementToBeVisible(locator);
        }
    }

    public void click(By locator) {
        WebElement e1 = find(locator);
        try {
            ActionsUtility.moveToElement(e1);
            e1.click();
            System.out.println("clicked on - " + locator);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Error (ElementClickInterceptedException) occurred while clicking the element - " + locator + ", trying javascript click ! ");
            JavaScriptUtility.jsClick(e1);
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
