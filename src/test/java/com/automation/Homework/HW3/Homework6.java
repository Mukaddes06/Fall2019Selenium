package com.automation.Homework.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework6 {
  // test case 6
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.tempmailaddress.com/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test6(){
        //Step 2. Copy and save email as a string.
        String email = driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(1);
        //Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(1);
        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(1);
        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Mukaddes");
        BrowserUtils.wait(1);
        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(email, Keys.ENTER);
        BrowserUtils.wait(1);
        //Step 7. Click Sign Up
        //Step 8. Verify that following message is displayed:
        //“Thank you for signing up. Click the button below to
        //return to the home page.”
        String actual = driver.findElement(By.tagName("h3")).getText();
        BrowserUtils.wait(1);
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected);
        //Step 9. Navigate back to the “https://
        //www.tempmailaddress.com/”
        //Step 10. Verify that you’ve received an email from
        //“do-not-reply@practice.cybertekschool.com”
        //Step 11. Click on that email to open it.
        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        //Step 13. Verify that subject is: “Thanks for
        //subscribing to practice.cybertekschool.com!”
        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(5);
        String expected1 = "do-not-reply@practice.cybertekschool.com";
        driver.findElement(By.xpath("//tbody[@id='schranka']//tr[@data-href='2'][1]//td[1]")).click();
        BrowserUtils.wait(1);
        String actual1 =driver.findElement(By.id("odesilatel")).getText();
        BrowserUtils.wait(1);
        Assert.assertEquals(actual1,expected1);
        String expected2 = "Thanks for subscribing to practice.cybertekschool.com!";
        String actual2 = driver.findElement(By.id("predmet")).getText();
        BrowserUtils.wait(1);
        Assert.assertEquals(actual2,expected2);
    }
}