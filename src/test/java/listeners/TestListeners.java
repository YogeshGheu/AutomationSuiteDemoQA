package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.base.BaseTest;
import utilities.ExtentReportsUtility;
import utilities.ScreenshotUtility;
//import utilities.ScreenshotUtility;

public class TestListeners implements ITestListener {
    ExtentReports reports;

    public void onTestStart(ITestResult result) {
        System.out.println("test case execution is starting : " + result.getMethod().getDescription());
        ExtentReportsUtility.createTest(result.getMethod().getDescription());
        ExtentReportsUtility.getTest().log(Status.INFO, "test case execution is starting : " + result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case is successful! : " + result.getMethod().getDescription());
        ExtentReportsUtility.getTest().pass("Test case is successful! : " + result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("test case failed! : " + result.getMethod().getDescription());
        ExtentReportsUtility.getTest().fail("test case failed! : " + result.getMethod().getDescription());
        ExtentReportsUtility.getTest().fail(result.getThrowable());

        String screenshotString = ScreenshotUtility.getScreenshotAsBase64();
        ExtentReportsUtility.getTest().addScreenCaptureFromBase64String(screenshotString);
        ExtentReportsUtility.getTest().log(Status.FAIL, "Screenshot: <br><img src='data:image/png;base64," + screenshotString + "' height='360' width='640' />");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("skipping the test case - " + result.getMethod().getDescription());
        ExtentReportsUtility.getTest().skip("skipping the test case - " + result.getMethod().getDescription());
    }

    public void onStart(ITestContext context) {
        System.out.println("test suite is starting");
        reports = ExtentReportsUtility.getExtentReports();
    }

    public void onFinish(ITestContext context) {
        System.out.println("test suite execution is finished");
        reports.flush();
    }
}
