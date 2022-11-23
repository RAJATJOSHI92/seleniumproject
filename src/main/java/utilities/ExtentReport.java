package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

     static  ExtentReports extentReport;

    public static ExtentReports getExtentReport() {

       // String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter("/Users/macbookpro/IdeaProjects/FramworkProject/Report/index.html");
        reporter.config().setReportName("TutorialsNinja Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("Operating System","MacOS");
        extentReport.setSystemInfo("Tested By","Rajat joshi");

        return extentReport;

    }

}
