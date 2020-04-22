package com.automation.Homework.HW4;

import com.automation.Homework.Utilities.BrowserUnit;
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

import java.util.List;


public class Cart {
    //1.go to https://amazon.com
    // 2.search for "wooden spoon"
    // 3.click search
    // 4.remember the name and the price of a random result
    // 5.click on that random result
    // 6.verify default quantity of items is 1
    // 7.verify that the name and the price is the same as the one from step 5
    // 8.verify button"Add to Cart" is visible

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
    }
    @Test
    public void test_cart() {
        List<WebElement> allItems = driver.findElements(By.xpath("(//div[@class='a-section a-spacing-medium'])"));
        int random = BrowserUnit.getRandom(allItems.size());

        String items= "(//div[@class='a-section a-spacing-medium'])["+random+"]";
        String itemPrice= "(//div[@class='a-section a-spacing-medium'])["+random+"]//span[@class='a-price-whole']";
        String itemPrice2 = "(//div[@class='a-section a-spacing-medium'])["+random+"]//span[@class='a-price-fraction']";
        String itemsName ="(//div[@class='a-section a-spacing-medium'])["+random+"]//span[@class='a-size-base-plus a-color-base a-text-normal']";

        String priceOfItem = driver.findElement(By.xpath(itemPrice)).getText()+"."+driver.findElement(By.xpath(itemPrice2)).getText();
        String nameOfItem = driver.findElement(By.xpath(itemsName)).getText();

        WebElement theRandomItem = driver.findElement(By.xpath(items));
        theRandomItem.click();

        String quantity = driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']//span[@class='a-dropdown-prompt']")).getText();

        Assert.assertEquals(quantity,"1");

        String priceOfVisible = driver.findElement(By.xpath("//span[contains(@id,'priceblock')]")).getText();
        String nameOfVisible = driver.findElement(By.id("productTitle")).getText();

        Assert.assertTrue(priceOfVisible.contains(priceOfItem));
        Assert.assertEquals(nameOfItem,nameOfVisible);

        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Add to Cart']")).isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
