package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWay {
    private WebDriver driver;
    @BeforeMethod
    private  void setUp(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        WebElement finisElement= driver.findElement(By.id("finish"));
        System.out.println(finisElement.getText());
    }
}
//manage(). timeouts(). implicitlyWait(0, TimeUnit. SECONDS);
// If the Web Driver can’t find the element immediately because
// it’s unavailable, then WebDriver will wait
// for mentioned time and it will not try to find the element again
// during the specified time period.
//Implicit means not stated directly but implied or hinted at.
//Explicit means stated directly. In other words,
// something explicit is very clear and exact about the meaning.