package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static void initReports() {
        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + File.separator + "reports"
                    + File.separator + "ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            // Spark Reporter Configuration
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("UI Test Execution");
            spark.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
