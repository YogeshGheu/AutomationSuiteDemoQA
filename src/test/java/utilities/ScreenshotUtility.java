package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Base64;

public class ScreenshotUtility {
    WebDriver driver;

    public ScreenshotUtility(WebDriver driver){
        this.driver = driver;
    }

    public String getScreenshotAsBase64(){
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }
}
