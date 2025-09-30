package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtility {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtility(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForElementToBeVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(By locator, int forSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(forSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
