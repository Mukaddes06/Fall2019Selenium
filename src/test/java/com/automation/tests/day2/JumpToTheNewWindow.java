package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        // every window has some id , this is calls window handle
        // base on window handle, we can switch in between windows
        String  windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        // getWindowHandle() - returns id's of all  currently opened window
        // Set doesn't allow duplicates
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH : " + driver.getCurrentUrl());


        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window

        for (String windowId: windowHandles){
            // if its not an old window , then switch
            if(windowId.equals(windowHandle)){
                // to jump to the window
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH : " + driver.getCurrentUrl());
        driver.close();
    }
}
