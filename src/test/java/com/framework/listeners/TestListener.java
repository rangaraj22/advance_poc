package com.framework.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.utils.ExtentManager;
import com.framework.utils.ScreenshotUtil;
import com.framework.base.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) { }

    @Override
    public void onFinish(ITestContext context) { }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getExtent().createTest(result.getMethod().getMethodName());
        result.setAttribute("extentTest", test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = (ExtentTest) result.getAttribute("extentTest");
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = (ExtentTest) result.getAttribute("extentTest");
        test.log(Status.FAIL, result.getThrowable());
        String path = ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
        if (path != null) {
            test.addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = (ExtentTest) result.getAttribute("extentTest");
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
}
