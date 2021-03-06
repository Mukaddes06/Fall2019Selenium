package OfficeHours;

import com.automation.utilities.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScripts {
    public static void main(String[] args) {
      //  @Test(description = "Send text to search box on etsy");
     //   public void test1(){
            //Driver instance created
            WebDriver driver = BrowserFactory.getDriver("chrome");
            //Navigating to etsy homepage
            driver.get("https://www.etsy.com/");
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
        }
    //}

    @Test(description = "get the page title (return a value)")
    public void testcase3(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }
}
