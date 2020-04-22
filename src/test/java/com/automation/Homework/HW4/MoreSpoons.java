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

import java.util.ArrayList;
import java.util.List;

public class MoreSpoons {
    //1.go to https://amazon.com
    //2.search for "wooden spoon"
    //3.remember all Brand names on the left
    //4.select Prime checkbox on the left
    //5.verify that same Brand names are still displayed


    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void Test(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']//following-sibling::input")).click();

        List<WebElement>brandNames = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/span"));
        List<String>s1=new ArrayList<>();
        for(WebElement each : brandNames){
            s1.add(each.getText());
        }

        driver.findElement(By.xpath("//i[@class='a-icon a-icon-prime a-icon-medium']/../div/label/i")).click();

        List<WebElement>moreSpoon = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/span"));
        List<String>s2=new ArrayList<>();
        for(WebElement each : moreSpoon){
            s2.add(each.getText());
        }
        Assert.assertEquals(s2,s1);
    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}