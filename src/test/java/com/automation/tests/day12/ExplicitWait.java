package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ExplicitWait {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }
    @Test
    public void waitForTitle(){
        driver.get("https://google.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleIs("Google"));
        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
//overlay screen ==> div element goes on top of page we have this page this screen,
// it will show up but not immediately there is a gap
//selenium starts manipulating once load done, but
// there is a gap=> between loading complete - overlay screen pop up
//submit button condition not helpful cause it becomes true even before overlay appears
//so we put condition:
//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));