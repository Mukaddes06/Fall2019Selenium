package com.automation.tests.day10;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    //we changed webdriver to RemoteWebdriver
    // reference type decided whats accesible
    // in the same to webdriver implement this class this webdriver interface invisible
    // this object will not able to use other method, other interfaces
    // remoteWebriver implement TakeAscreenhot(Interface), Webdrive(Interface),
    // JavascirptExecutor(Interface), SearcContext(Interface)
    // this class can reach all interfaces class methods
    // but reference type has WhichType interfaces this class
    // just can use reached interfaces methods
    // it uses latest model of version methods

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
//        driver = DriverFactory.createDriver("chrome");//we changed webdriver to RemoteWebdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
//        you need to cast if reference type is a WebDriver
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
//        x, y offset
        for (int i=0; i < 10; i++){
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(3);
    }

    @Test
        public void scrollToElementTest() {
            driver.get("http://practice.cybertekschool.com/");
            driver.manage().window().maximize();
            WebElement link = driver.findElement(By.linkText("Cybertek School"));
            // argumnt this elements --> link (Scrool until it becoms visible)
        //scrollIntoView - javascript method
        //arguments[0] - means 1st webelement after comma
            driver.executeScript("arguments[0].scrollIntoView(true)", link);
        }

    }
//casting also, same idea with converting data type  .
// its doenst mean that it should be upcast or downcast.

//Why do we need JavaScriptExecutor?
//In Selenium Webdriver, locators like XPath, CSS, etc. are used to
// identify and perform operations on a web page.
//In case, these locators do not work you can use
// JavaScriptExecutor. You can use JavaScriptExecutor to
// perform an desired operation on a web element.

//how to use javaScriptExecutor?
//javaScriptExecutor; it is an interface we can not create object out of it.
//But javascript executor and webDriver are like siblings
//So we will cast driver to JavascriptExecutor
//we convert webDriver object into JavaScriptExecutor
//JavascriptExecutor js = (JavascriptExecutor) driver;
//interface => they don't have implementation
//if you have interface as reference type you can see methods only coming from that interface
//you can not see other methods that are in other interfaces
//so we will use remoteWebDriver class as reference type :
//if you use remoteWebDriver class as reference type you do not need to cast anymore, it has everything
//like this => private RemoteWebDriver driver;
//driver.executeScript("window.scrollBy(0, 250)");
//you need to cast if your reference type is webDriver; like this =>  private WebDriver driver;
//JavascriptExecutor js = (JavascriptExecutor) driver;

