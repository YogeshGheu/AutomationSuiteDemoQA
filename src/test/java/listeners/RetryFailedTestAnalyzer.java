package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;

    public boolean retry(ITestResult result) {
        int maxRetryCount = 2;
        if(retryCount < maxRetryCount){
            retryCount ++;
            System.out.println("Failed Test: \"" + result.getMethod().getDescription() + "\", trying " + ( retryCount + 1 ) + " time(s)");
            return true;
        }
        return false;
    }
}
