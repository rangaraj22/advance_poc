package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import com.framework.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
    	
    	//base url read from config file
    	String url = ConfigReader.get("baseUrl");
    	
    	//single config file with environment
    	/*
    	String qaurl = ConfigReader.get("qaUrl");
    	String uaturl = ConfigReader.get("uatUrl");
    	String produrl = ConfigReader.get("prodUrl");
    	
    	String env = ConfigReader.get("env");
    	String url = ConfigReader.get(env);
    	*/
    	//browser
        setup("chrome");
        
        //test class
        LoginPage lp = new LoginPage(driver);
        lp.open(url);
     //   lp.login("admin", "password");
        // add an assertion example (modify according to actual app)
       // Assert.assertTrue(driver.getTitle() != null);
    }
}
