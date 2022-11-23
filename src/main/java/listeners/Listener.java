package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import utilities.ExtentReport;

import java.io.IOException;

public class Listener extends Base implements ITestListener {
  public   WebDriver driver;
    ExtentReports extentreport = ExtentReport.getExtentReport();
    ExtentTest extenttest;
    @Override
    public void onTestStart(ITestResult result) {
        String testName=result.getName();
         extenttest = extentreport.createTest(testName+ "execution started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName=result.getName();
          extenttest.log(Status.PASS,testName+"got passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
      String testMethodName = result.getName();
      extenttest.fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try {
            takeScreenshot(testMethodName,driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
extentreport.flush();
    }
}
