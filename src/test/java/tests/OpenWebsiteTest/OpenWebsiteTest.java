package tests.OpenWebsiteTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;

public class OpenWebsiteTest extends BaseTest {
    @Test
    public void testOpeningWebsite(){
        WebDriver driver = getDriver();
        Assert.assertEquals(driver.getTitle(), "DEMOQA", "Test Failed - Page title did not matched. Actual Title: " + driver.getTitle());
    }
}
