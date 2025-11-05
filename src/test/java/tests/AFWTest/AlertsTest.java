package tests.AFWTest;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.AFW.childPages.AlertsPage;
import utilities.SwitchToUtility;
import utilities.WaitUtility;

public class AlertsTest extends BaseTest {

    @Test(description = "test alerts functionality")
    public void testAlerts() {
        Homepage homepage = new Homepage(getDriver());
        AlertsPage alertsPage = homepage.clickAFWTile().clickMenuItemAlerts();

        //test normal click alert
        alertsPage.generateClickAlert();
        SwitchToUtility.acceptAlert();

        //test wait alert - will appear after 5 seconds
        alertsPage.generateAlertAfterFiveSeconds();
//        WaitUtility.threadSleep(6);
        WaitUtility.waitUntilAlertIsPresent(5);
        String actualAlertText = SwitchToUtility.getAlertText();
        String expectedText = "This alert appeared after 5 seconds";
        Assert.assertEquals(actualAlertText, expectedText, "wait alert's text doesn't match or the alert is not visible!");
        SwitchToUtility.acceptAlert();

        // test confirm/dismiss - confirm alert
        alertsPage.generateConfirmAlert();
        SwitchToUtility.acceptAlert();
        String actualConfirmAlertText = alertsPage.getConfirmAlertResult();
        String expectedConfirmAlertText = "You selected Ok";
        Assert.assertEquals(actualConfirmAlertText, expectedConfirmAlertText);


        // test confirm/dismiss - dismiss alert
        alertsPage.generateConfirmAlert();
        SwitchToUtility.dismissAlert();
        String actualConfirmAlertTextForDismiss = alertsPage.getConfirmAlertResult();
        String expectedConfirmAlertTextForDismiss = "You selected Cancel";
        Assert.assertEquals(actualConfirmAlertTextForDismiss, expectedConfirmAlertTextForDismiss);

        //test prompt alert
        alertsPage.generatePromptAlert();
        String textToSendInAlert = "hello world ! (This is Yogesh).";
        SwitchToUtility.sendTextToAlert(textToSendInAlert);
        SwitchToUtility.acceptAlert();
        String actualTextReceivedInPrompt = alertsPage.getPromptAlertResult();
        Assert.assertEquals(actualTextReceivedInPrompt, "You entered " + textToSendInAlert);

    }
}
