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

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todays_Date {
    /*
    1.go to http://practice.cybertekschool.com/dropdown2.
    verify  that dropdowns under Select your date of birth display current year, month,day
     */

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void todays_date(){
        WebElement year= driver.findElement(By.id("year"));
        WebElement month= driver.findElement(By.id("month"));
        WebElement day= driver.findElement(By.id("day"));

        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);

        String year_value = y.getFirstSelectedOption().getText();
        String month_value = m.getFirstSelectedOption().getText();
        String day_value = d.getFirstSelectedOption().getText();

        SimpleDateFormat actual= new SimpleDateFormat("yyyyMMMMdd");

        Assert.assertEquals(year_value + month_value + day_value, actual.format(new Date()));

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
