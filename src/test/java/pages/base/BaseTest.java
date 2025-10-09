package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertiesUtility;

import java.time.Duration;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void initDriver(){
        String baseUrl = PropertiesUtility.get("BASE_URL");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        WebDriver driverInstance = new ChromeDriver(options);
        driverInstance.manage().window().maximize();
        driverInstance.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        if(baseUrl != null){
            driverInstance.get(baseUrl);
        }else {
            throw new RuntimeException("Unable to start the automation suite - base URL not found!");
        }
        driverThreadLocal.set(driverInstance);
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    @AfterMethod
    public void teardown(){
        if(driverThreadLocal.get() != null){
            driverThreadLocal.get().close();
            driverThreadLocal.remove();
        }
    }
}
