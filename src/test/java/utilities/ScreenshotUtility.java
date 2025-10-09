package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Base64;

public class ScreenshotUtility extends BaseUtility {

    public static String getScreenshotAsBase64(){
        TakesScreenshot screenshot = ((TakesScreenshot)getDriver());
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }
}
