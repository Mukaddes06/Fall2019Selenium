package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {
        // unit testing
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        // assertion
        verifyEquals(expected, actual);

    }
    // annotation (we use here for unit test)
    @Test(description = "Verify if method can reverse a string") // just explanation what is the purpose of test
    public  void test(){
        String expected ="RAC";
        String actual= reverseString("CAR");
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Verify if method can reverse a string") // just explanation what is the purpose of test
    public  void test2(){
        String expected ="elppa";
        String actual= reverseString("apple");
        Assert.assertEquals(actual, expected);
    }
// we need to method for verify
    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }
    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}