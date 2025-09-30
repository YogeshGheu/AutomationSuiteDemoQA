package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
    WebDriver driver;

    public JavaScriptUtility(WebDriver driver){
        this.driver = driver;
    }

    public void jsClick(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void jsScroll(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
