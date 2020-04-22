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
import java.util.ArrayList;
import java.util.List;

public class Main_Departments {
    //1.go to https://www.amazon.com/gp/site-directory
    //2.verify that every main department name(indicated by blue rectangles in the picture)
    //is present in the All departments dropdown (indicated by green rectangle in the picture)
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/gp/site-directory");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void test(){

        List<WebElement> maindepartaments=driver.findElements(By.cssSelector(".fsdDeptTitle"));
        List<WebElement> alldepartments=driver.findElements(By.cssSelector("#searchDropdownBox>option"));

        for (int i = 0; i < maindepartaments.size(); i++) {
            for (int j = 0; j <alldepartments.size() ; j++) {
                String maineach=maindepartaments.get(i).getText();
                String alleach=alldepartments.get(j).getText();
                Assert.assertTrue(maineach==alleach);
            }
        }

    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
