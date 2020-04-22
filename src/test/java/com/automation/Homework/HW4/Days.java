package com.automation.Homework.HW4;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class Days {
    /*
    1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
    2.Randomly select a checkbox. As soon as you check any day,
    print the name of the day and uncheck immediately.
    After you check and uncheck Friday for the third time, exit the program.
    NOTE: Remember some checkboxes are not selectable.
     You need to find a way to ignore them when they are randomly selected.
    It has to be dynamic.
    Do not hard code Saturday and Sunday. Use values of certain attributes.
     */

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();

    }


    @Test
    public void Test(){
        // it is check name of the days
        List<WebElement> days = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        // it is check checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        Random random = new Random();
        int count = 0;

        while(count<3){
            int index = random.nextInt(days.size());
            if(checkboxes.get(index).isEnabled()){
                days.get(index).click();
                if(days.get(index).getText().equals("Friday")){
                    count++;
                }
                System.out.println("Selected : " + days.get(index).getText());
                days.get(index).click();
            }
        }
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


}