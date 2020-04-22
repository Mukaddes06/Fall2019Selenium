package com.automation.Homework.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Valid_Links {
    //1.go to https://www.selenium.dev/documentation/en/
    // 2.find all the elements in the page with the tag a
    // 3.verify that all the links are valid

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.selenium.dev/documentation/en/");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void Test() {
        List<WebElement> allATags = driver.findElements(By.tagName("a"));
        System.out.println(allATags.size());

        List<String> allLinks = new ArrayList<>();
        BrowserUtils.wait(2);

        allATags.forEach(each -> allLinks.add(each.getAttribute("href")));
        System.out.println(allLinks);

        Assert.assertTrue(allLinks.contains(null), "valid link");
    }



        @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}