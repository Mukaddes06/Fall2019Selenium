package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTestNGTests {
    @BeforeTest
    public  void beforeTest(){
        System.out.println("BEFORE TEST");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @BeforeTest
    public void setup(){
        System.out.println("BEFORE METHOD");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");

    }
    @Test
    public  void test1(){
        System.out.println("TEST 1");
        String  expected = "apple";
        String actual= "apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("TEST 2");

        int num=5;
        int num2=10;
        // IT calls hard assertion
        // if assertion fails - it stops the execution(due to expection)
        Assert.assertTrue(num>num2);

    }
}
