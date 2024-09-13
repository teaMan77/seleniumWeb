package day23;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    public void onStart(ITestContext context)
    {
        System.out.println("The test execution has started...!");
    }

    public void onTestStart(ITestResult result)
    {
        System.out.println("The test has started...!");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The test has passed...!");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("The test has failed...!");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The test was skipped...!");
    }

    public void onFinish(ITestContext context)
    {
        System.out.println("The test execution is finished...!");
    }

}
