package com.automation.Homework.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Prime {
    //1.go to https://amazon.com
    //2.search for "wooden spoon"
    //3.click search
    // 4.remember name first result that has prime label
    // 5.select Prime check box on the left
    // 6.verify that name first result that has prime label is same as step 4
    // 7.check the last checkbox under Brand on the left
    // 8.verify that name first result that has prime label is different

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

        String firstPrimeName = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[1]")).getText();
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-prime a-icon-medium']/../div/label/i")).click();

        String newPrimeName = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[1]")).getText();
        Assert.assertEquals(newPrimeName, firstPrimeName);

        driver.findElement(By.xpath("//div[@id='brandsRefinements']//ul/li[last()]//i")).click();
        String newBrandName = driver.findElement(By.xpath("(//i[@aria-label='Amazon Prime']/../../../../../..//h2)[1]")).getText();

        System.out.println(firstPrimeName);
        System.out.println(newPrimeName);
        System.out.println(newBrandName);

        Assert.assertNotEquals(newBrandName, firstPrimeName);
    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
