package com.automation.Homework.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Links {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.w3schools.com/");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void Test(){
        List<WebElement> tagA = driver.findElements(By.tagName("a"));
        for(WebElement each : tagA){
            if(each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }

    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}


