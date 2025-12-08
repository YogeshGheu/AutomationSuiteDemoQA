package tests.widgetsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.widgets.childPages.ToolTipsPage;
import utilities.WaitUtility;

public class ToolTipTest extends BaseTest {

    @Test(description = "test the Tool Tip functionality")
    public void testToolTip(){
        Homepage homepage = new Homepage(getDriver());
        ToolTipsPage toolTipsPage = homepage.clickWidgetsTile().clickToolTipsMenuItem();

        // test if the page is displayed
        Assert.assertTrue(toolTipsPage.isToolTipsPageHeadingVisible());

        // test button tooltip
        WaitUtility.threadSleep(5);
        toolTipsPage.hoverOnButton();
        Assert.assertTrue(toolTipsPage.isButtonToolTipVisible());

        // test text field tooltip
        WaitUtility.threadSleep(5);
        toolTipsPage.hoverOverTextField();
        Assert.assertTrue(toolTipsPage.isTextFieldToolTipVisible());
    }
}
