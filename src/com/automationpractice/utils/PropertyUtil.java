package com.automationpractice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Muthuvenkatrm on 26/03/2018.
 */
public class PropertyUtil {
    

    private static String propertyFilename = System.getProperty("user.dir") + "/src/property_files/Testdata.properties";

    public static String getStringPropValue(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        String result = "";
        try {
            prop.load(new FileInputStream(propertyFilename));
            result = prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    }