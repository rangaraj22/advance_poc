package com.framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + File.separator + "reports" + File.separator + name + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
            FileUtils.copyFile(src, new File(dest));
            return dest;
        } catch (Exception e) {
            return null;
        }
    }
}
