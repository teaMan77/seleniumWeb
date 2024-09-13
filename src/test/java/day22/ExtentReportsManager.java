package day22;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportsManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;  //UI of the report
    public ExtentReports extent;  //Populate common info on the report
    public ExtentTest test;  //creating testcase entries in the report and updating the status of the test methods

    public void onStart(ITestContext context)
    {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/parallelReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Adarsh");
        extent.setSystemInfo("OS", "WINDOWS-11");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public void onTestSuccess(ITestResult result)
    {
        test = extent.createTest(result.getName());  //creating a new entry in the report
        test.log(Status.PASS, "Test case passed is: " + result.getName());  //update the status
    }

    public void onTestFailure(ITestResult result)
    {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case failed is: " + result.getName());
    }

    public void onTestSkipped(ITestResult result)
    {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped is: " + result.getName());
    }

    public void onFinish(ITestContext context)
    {
        extent.flush();
    }
}
