package com.automation.tests.day7;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Xpath {
    // when we have lots of locator better keep instance variable here
    // easier way otherwise we are gonna do copy same locator again and again
    // we save them here seperatly
    // public makes seems everywhere so we can easily use by other classes
    // this make our code too organize
    // static belongs to class so we shoul create outside the class
    // if we dont put access modifier it calls package private--> this members ony visible same package
    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator = "//button[contains(text(), 'Login')]";
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();
        BrowserUtils.wait(3);
        driver.quit();
    }
}
