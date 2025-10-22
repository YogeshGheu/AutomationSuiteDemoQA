package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtility extends BaseUtility{

    public static void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeVisible(By locator, int forSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(forSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(By locator, int forSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(forSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilAlertIsPresent(int seconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds * 1000L));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void threadSleep(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}
