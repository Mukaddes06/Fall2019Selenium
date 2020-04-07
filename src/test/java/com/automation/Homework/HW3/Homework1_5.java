package com.automation.Homework.HW3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Homework1_5 {
    // test case 1,2,3,4,5
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Registration Form")).click();
    }
  // test case 1
    @Test
    public void TestCase1(){
    driver.findElement(By.name("birthday")).sendKeys("wrong_dab");
    String expected = "The date of birth is not valid";
    String actual = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-for=\"birthday\"][2]")).getText();
    Assert.assertEquals(expected,actual);
    }
    /** test case 2
     * Step 1. Go to “https://practicecybertekschool.
     * herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Verify that following options for
     * programming languages are displayed: c++, java,
     * JavaScript
     */
    @Test
    public void Test2(){
        List<WebElement> listofprog = (List<WebElement>) driver.findElements(By.xpath("//div[@class ='form-check form-check-inline']/label"));
        Assert.assertEquals(listofprog.get(0).getText(),"C++");
        Assert.assertEquals(listofprog.get(1).getText(),"Java");
        Assert.assertEquals(listofprog.get(2).getText(),"JavaScript");
    }
    /** test case 3
     * Step 1. Go to “https://practicecybertekschool.
     * herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter only one alphabetic character into first
     * name input box.
     * Step 4. Verify that warning message is displayed:
     * “first name must be more than 2 and less than 64
     * characters long”
     */
    @Test
    public void Test3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
        String expected ="first name must be more than 2 and less than 64 characters long";
        String actual =driver.findElement(By.xpath("//small[@data-bv-for=\"firstname\"][2]")).getText();
        Assert.assertEquals(expected,actual);
    }
    /** test case 4
     * Step 1. Go to https://practicecybertekschool.
     * herokuapp.com
     * Step 2. Click on “Registration Form”
     * Step 3. Enter only one alphabetic character into last
     * name input box.
     * Step 4. Verify that warning message is displayed:
     * “The last name must be more than 2 and less than
     * 64 characters long”
     */
    @Test
    public void Test4(){
        driver.findElement(By.name("lastname")).sendKeys("a");
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//small[@data-bv-for=\"lastname\"][2]")).getText();
        Assert.assertEquals(expected,actual);
    }
    /** test case 5
     * Step 1. Go to “https://practicecybertekschool.
     * herokuapp.com”
     * Step 2. Click on “Registration Form”
     * Step 3. Enter any valid first name.
     * Step 4. Enter any valid last name.
     * Step 5. Enter any valid user name.
     * Step 6. Enter any valid password.
     * Step 7. Enter any valid phone number.
     * Step 8. Select gender.
     * Step 9. Enter any valid date of birth.
     * Step 10. Select any department.
     * Step 11. Enter any job title.
     * Step 12. Select java as a programming language.
     * Step 13. Click Sign up.
     * Step 14. Verify that following success message is
     * displayed: “You've successfully completed
     * registration!”
     * Note: for using dropdown, please refer to the
     * documentation: https://selenium.dev/selenium/
     * docs/api/java/org/openqa/selenium/support/ui/
     * Select.html or, please watch short video about dropdowns
     * that is posted on canvas.
     */
    @Test
    public void test5(){
        driver.findElement(By.name("firstname")).sendKeys("Mukaddes");
        driver.findElement(By.name("lastname")).sendKeys("Ayik");
        driver.findElement(By.name("username")).sendKeys("mukaddesa");
        driver.findElement(By.name("email")).sendKeys("mukaddes_06_@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.name("phone")).sendKeys("455-678-8888");
        //radiobutton
        driver.findElements(By.name("gender")).get(1).click();
        driver.findElement(By.name("birthday")).sendKeys("4/21/2020");
        new Select(driver.findElement(By.name("department"))).getOptions().get(1).click();
        new Select(driver.findElement(By.name("job_title"))).getOptions().get(5).click();
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expected ="You've successfully completed registration!";
        String actual=driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(expected,actual);

    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
