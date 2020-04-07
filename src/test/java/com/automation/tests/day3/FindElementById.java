package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();


        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //let's click on Logout button. It looks like a button, but it's actually a link
        //every element with <a>--> it is HyperLink it is visible text -->tag is a link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains() - complete match doesn't required
        //don't put space
        // if doesnt work with linkText we need to partialLinkedText
        // partialLinkText just remove space
        // partialLink always help with contently changing text
        // partial =Link always the different

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        // logout it is inside another element but still partiallinkTest
        // if you have a space locator very very sensitive
        // <a is tag    > Logout</i --> is a tags

        //for the read this href attribute
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");// for the class read attribute
        // make sure this attribute in the element
        System.out.println(href);
        System.out.println(className);
        logout.click();
        Thread.sleep(2000);



        driver.quit();
    }
}