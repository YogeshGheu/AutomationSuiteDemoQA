package utilities;

import org.openqa.selenium.WebDriver;

public class BaseUtility {

    protected static ThreadLocal<WebDriver> driverInst = new ThreadLocal<>();

    public static void setUtilityDriver(WebDriver driver){
        driverInst.set(driver);
    }

    public static WebDriver getDriver(){
        return driverInst.get();
    }
}
