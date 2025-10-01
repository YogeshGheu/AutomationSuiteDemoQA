package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility {

    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getExtentReports(){
        if(extentReports == null){
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/extentReports/extent-report.html");
            reporter.config().setReportName("Test Report - DemoQA");
            reporter.config().setTheme(Theme.DARK);

            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Environment", "INT");
            extentReports.setSystemInfo("QA", "Yogesh Gheu");
            extentReports.setSystemInfo("Browser", "Chrome");
        }
        return extentReports;
    }

    public static void createTest(String name){
        ExtentTest test = extentReports.createTest(name);
        extentTest.set(test);
    }


    public static ExtentTest getTest(){
        return extentTest.get();
    }
}
