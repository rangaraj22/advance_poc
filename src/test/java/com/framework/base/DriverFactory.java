package com.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void setDriver(String browser) {
        if (browser == null) browser = "chrome";
        browser = browser.toLowerCase();
        if (tlDriver.get() == null) {
            switch (browser) {
                case "firefox":		
                    WebDriverManager.firefoxdriver().setup();
                    tlDriver.set(new FirefoxDriver());
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    tlDriver.set(new ChromeDriver());
            }
        }
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
