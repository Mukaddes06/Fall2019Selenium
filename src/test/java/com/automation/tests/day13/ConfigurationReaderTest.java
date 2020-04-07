package com.automation.tests.day13;
import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;
public class ConfigurationReaderTest {
    @Test
    public void readProperties(){
        // when we create getProperty this is available for us
        // it give us chrome inside the configuration.properties
        // instead of we write 'abc' it turns null

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        String color = ConfigurationReader.getProperty("color");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(color);

        String storeManager = ConfigurationReader.getProperty("store_manager");
        String password = ConfigurationReader.getProperty("password");
        String driver = ConfigurationReader.getProperty("driver");
        System.out.println(storeManager);
        System.out.println(password);
        System.out.println(driver);
        //break until 9:05
    }
}