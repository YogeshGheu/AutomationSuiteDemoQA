package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends BaseUtility{


    public static void jsClick(WebElement element){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void jsScroll(WebElement element){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

