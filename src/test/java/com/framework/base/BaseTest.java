package com.framework.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.utils.ExtentManager;
import com.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
  
	protected WebDriver driver;
    protected ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        ExtentManager.initReports();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        ExtentManager.flushReports();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser){
    	
    	 //no environemnt selection - single config.properties
    	 //ConfigReader.init();
    	 
    	/*
    	//environment selection
    	String env = System.getProperty("env", "qa");
    	ConfigReader.init(env);
        */	
        
        DriverFactory.setDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
        		Duration.ofSeconds(Integer.parseInt(ConfigReader.get("implicitWait"))));
    }
/*
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
    */
}
