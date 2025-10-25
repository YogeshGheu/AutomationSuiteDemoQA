package tests.AFWTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.AFW.childPages.BrowserWindowsPage;
import utilities.SwitchToUtility;
import utilities.WaitUtility;

public class BrowserWindowsTest extends BaseTest {
    @Test(description = "Test browser windows switching")
    public void testBrowserWindows(){
        Homepage homepage = new Homepage(getDriver());
        BrowserWindowsPage browserWindowsPage = homepage.clickAFWTile().clickMenuItemBrowserWindows();


        // 1.  test windows
        browserWindowsPage.clickNewWindowButton();
        SwitchToUtility.switchToWindow("childWindow");
        String textOnNewWindow = browserWindowsPage.getTextOnNewWindow();
        String expectedTextOnNewWindow = "This is a sample page";
        Assert.assertEquals(textOnNewWindow, expectedTextOnNewWindow, "Text on new window does not match with the expected text!");
        // close the child window
        SwitchToUtility.closeWindow("childWindow");
        // switch back to parent window
        SwitchToUtility.switchToWindow("parentWindow");
        boolean isMainWindowVisible = browserWindowsPage.isOnMainWindowsPage();
        Assert.assertTrue(isMainWindowVisible, "parent window is not visible!");


        // 2. test new window with message
        browserWindowsPage.clickGetNewWindowMessageButton();
        SwitchToUtility.switchToWindow("childWindow");
        Assert.assertEquals(getDriver().getWindowHandle(), BrowserWindowsPage.windowsIds.get("childWindow"),  "Message window is not visible!");
        // close the child window
        SwitchToUtility.closeWindow("childWindow");
        // switch back to parent window
        SwitchToUtility.switchToWindow("parentWindow");
        boolean isParentWindowVisible = browserWindowsPage.isOnMainWindowsPage();
        Assert.assertTrue(isParentWindowVisible, "parent window is not visible!");

        // 3. test new tab
        browserWindowsPage.clickNewTabButton();
        SwitchToUtility.switchToWindow("childWindow");
        String textOnNewTab = browserWindowsPage.getTextOnNewWindow();
        String expectedTextOnNewTab = "This is a sample page";
        Assert.assertEquals(textOnNewTab, expectedTextOnNewTab, "Text on new tab does not match with the expected text!");
        // close the child tab
        SwitchToUtility.closeWindow("childWindow");
        // switch back to parent tab
        SwitchToUtility.switchToWindow("parentWindow");
        boolean isMainTabVisible = browserWindowsPage.isOnMainWindowsPage();
        Assert.assertTrue(isMainTabVisible, "parent window is not visible!");

    }
}
