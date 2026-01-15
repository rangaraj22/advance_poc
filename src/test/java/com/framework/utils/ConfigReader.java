package com.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void init() {
        try {
            prop = new Properties();
            
        /*
          //single config property files
            String configproperties = "src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(configproperties);
          */  
            
            //Read env from maven or default to qa
            String env = System.getProperty("env");
            if (env == null || env.isEmpty()) {
            	env = "qa";   // default environment 
            }
            
            String configFilepath ="src/test/resources/config-" +env + ".properties"; 
            FileInputStream fis = new FileInputStream(configFilepath);
            
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        if (prop == null) {
        	
        	init();
        }
        return prop.getProperty(key);
    }
}
