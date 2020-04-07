package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {//configuration properties file path
    private static Properties configFile;

    static { // static block will be executed only once , whenever somebody call this class
        // also there is instance block
          // Static block has the highest priority in terms of execution order
           // 1-static block
          // 2-instance block
        // 3- constructor
        try {
            //location of properties file (to get the file)
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            // when this file is not found it throws
            throw new RuntimeException("Failed to load properties file!");
        }

    }

    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) { // call this method and provide a key name
                                           // to get a value
        // for example: ConfigurationReader.grtProperty["browser"]
        return configFile.getProperty(keyName);
    }

}
//whenever you call this class (ConfigurationReader) =>  static block will be executed
//ConfigurationReader class ==> we need this class to load and to use configuration file
//to get configuration.properties => call getProperty method