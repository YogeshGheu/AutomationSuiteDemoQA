package tests.elementsTests;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.childPages.DynamicPropertiesPage;
import utilities.WaitUtility;

public class DynamicPropertiesTest extends BaseTest {

    @Test(description = "test dynamic properties", priority = 1)
    public void testDynamicProperties(){
        Homepage homepage = new Homepage(getDriver());
        DynamicPropertiesPage page = homepage.clickElementsTile().clickDynamicPropertiesLabelFromDropdown();

        String expectedClassBeforeFiveSeconds = "mt-4 btn btn-primary";
        String expectedClassAfterFiveSeconds = "mt-4 text-danger btn btn-primary";

        // initial assertions
        Assert.assertFalse(page.isFiveSecondsButtonEnabled(), "Five Seconds Button is Enabled before 5 seconds");
        Assert.assertFalse(page.isFiveSecondsButtonVisible(), "Five Seconds Button is Visible before 5 seconds");
        Assert.assertEquals(page.getColorChangeButtonClass(), expectedClassBeforeFiveSeconds);
        System.out.println("Random Id of the text is : " + page.getRandomIdOfText());

        // wait for exact five seconds
        getDriver().navigate().refresh();
        WaitUtility.threadSleep(5);

        // Assertions after five seconds
        Assert.assertTrue(page.isFiveSecondsButtonEnabled(), "Five Seconds Button is disabled after 5 seconds");
        Assert.assertTrue(page.isFiveSecondsButtonVisible(), "Five Seconds Button is not visible after 5 seconds");
        Assert.assertEquals(page.getColorChangeButtonClass(), expectedClassAfterFiveSeconds);
        System.out.println("Random Id of the text is : " + page.getRandomIdOfText());

    }
}
