package demo_maven.tlooc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport_Diabetes {
    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports() {
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
        return extentReports;
    }
}
