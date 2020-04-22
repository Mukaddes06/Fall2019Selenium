package com.automation.Homework.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Depatment_Sort {
    //1.go to https://www.amazon.com
    // 2.verify that default value of the All departments dropdown is All
    // 3.verify that options in the All departments dropdown are not sorted alphabetically
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }

    @Test
    public void department_sort(){
        Assert.assertEquals(driver.findElement(By.className("nav-search-label")).getText(),"All");
        List<WebElement> list = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();
        boolean notAlphabetOrder = false;
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i).getText().compareTo(list.get(i+1).getText())>0){
                notAlphabetOrder=true;
                break;
            }
        }
        Assert.assertTrue(notAlphabetOrder);
    }


        @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }



}
