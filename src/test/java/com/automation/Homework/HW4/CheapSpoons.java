package com.automation.Homework.HW4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheapSpoons {
    //1.go to https://amazon.com
    //2.search for "wooden spoon"
    //3.click on Price option Under $25 on the left
    //4.verify that all results are cheaper than $25

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void test() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']//following-sibling::input")).click();
        driver.findElement(By.xpath("//div[@id='priceRefinements']//ul/li/span/a/span")).click();

        List<String>prices = new ArrayList<>();
        List<WebElement>price = driver.findElements(By.xpath("//span[@class='a-price']/span[@class='a-offscreen']"));

        double max = 0.0;
        for (int i = 1; i < price.size(); i++) {
            String p = driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[2])[" + i + "]")).getText()
                    + "." + driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[3])[" + i + "]")).getText();
            prices.add(p);

            double pp = Double.parseDouble(p);

            System.out.println(pp);
            if(pp>max){
                max = pp;
            }
        }
        Assert.assertTrue(max<25.00);
    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}