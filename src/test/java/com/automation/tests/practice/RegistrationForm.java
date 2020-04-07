package com.automation.tests.practice;

import bsh.StringUtil;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private  String URL= "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;

    //private  String firstNameLocator ="firstname";
    //private  String lastNameLocator ="lastname";

    private  By firstNameBy= By.name("firstname");
    private  By lastNameBy=By.name("lastname");
    private  By usernameBy=By.name("username");
    private By email=By.name("email");
    private By passworBy=By.name("password");
    private By phoneBy= By.name("phone");
    //gender
    private  By maleBy=By.cssSelector("input[value='male']");
    private By femaleBy= By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy=By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy=By.name("job_title");

    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy=By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signUpBy=By.id("wooden_spoon");

    @Test
    public void test1(){
driver.findElement(firstNameBy).sendKeys("Patrick");
driver.findElement(lastNameBy).sendKeys("White");
driver.findElement(usernameBy).sendKeys("tessuser");
driver.findElement(email).sendKeys("test@gmail.com");
driver.findElement(passworBy).sendKeys("12345678");
driver.findElement(phoneBy).sendKeys("768-987-7777");
driver.findElement(femaleBy).click();
driver.findElement(dateOfBirthBy).sendKeys("01/02/1940");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitle= new Select(driver.findElement(jobTitleBy));
        jobTitle.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(5);

        String expected= "You've succesfully completed registration!";
        String  actual =driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual,expected);

    }
    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }
    @Test
    public  void verifyAlphabeticLetterOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
