package com.automation.Homework.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


    public class Homework7_8 {

        public WebDriver driver;



        @BeforeMethod
        public void setup(){
            driver= DriverFactory.createDriver("chrome");
            driver.manage().window().maximize();
            BrowserUtils.wait(6);
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            BrowserUtils.wait(5);
            driver.findElement(By.xpath("//a[.='File Upload']")).click();
            BrowserUtils.wait(2);
        }

        @Test
        public void test7(){

            WebElement file=  driver.findElement(By.id("file-upload"));
            file.sendKeys("C:\\Users\\19564\\OneDrive\\Documents\\Book1.xlsx");

            driver.findElement(By.xpath("//input[@id='file-submit']")).click();
            BrowserUtils.wait(5);
            String actual1 = driver.findElement(By.tagName("h3")).getText();
            BrowserUtils.wait(5);
            Assert.assertEquals(actual1,"File Uploaded!");
            BrowserUtils.wait(5);
            WebElement e = driver.findElement(By.id("uploaded-files"));
            String actual=e.getText();
            Assert.assertEquals(actual,"Book1.xlsx");


        }
        @Test
        public void test8(){
            driver.findElement(By.linkText("Autocomplete")).click();
            BrowserUtils.wait(5);
            driver.findElement(By.id("myCountry")).sendKeys("Turkey");
            BrowserUtils.wait(3);
            driver.findElement(By.xpath("//input[@value='Submit']")).click();
            BrowserUtils.wait(3);
            String actual = driver.findElement(By.xpath("//p[@id='result']")).getText();
            BrowserUtils.wait(3);
            Assert.assertEquals(actual,"You selected: Turkey");
        }


        @AfterMethod
        public void teardown(){
            driver.quit();
        }

    }