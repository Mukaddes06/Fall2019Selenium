package com.automation.Homework.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homework9_12 {
    public WebDriver driver;
    // test case 9, 10, 11, 12

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        BrowserUtils.wait(6);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(5);
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(5);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(dataProvider = "testData")
    public void test(By a, By b , String str){
        driver.findElement(a).click();
        BrowserUtils.wait(5);
        String actual =driver.findElement(b).getText();
        String expected = str;

        Assert.assertTrue(actual.contains(expected));

    }

    @DataProvider(name = "testData")
    public Object[][] testData(){

        return new Object[][]{{By.linkText("200"),By.tagName("p"),"This page returned a 200 status code"},
                {By.linkText("301"),By.tagName("p"),"This page returned a 301 status code"},
                {By.linkText("404"),By.tagName("p"),"This page returned a 404 status code"},
                {By.linkText("500"),By.tagName("p"),"This page returned a 500 status code"}};
    }
}