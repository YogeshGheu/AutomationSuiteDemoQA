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

    public static void threadSleep(int seconds){
        try {
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}
