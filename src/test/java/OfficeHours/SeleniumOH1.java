package OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {

    /*
    -Iterator
          -List, Set, Map and other types of collections can use Iterator class to iterate over that collection
          -List has indexes (for i, for each, while, Iterator)
          -Map (for each, Iterator - to loop through keys)
     -Basic Selenium Navigation
     */

    public static void main(String[] args) {
        // Create Arraylist of String - iterate over it

        ArrayList<String>  keysToSearc = new ArrayList<>();
        keysToSearc.add("fruits");
        keysToSearc.add("veggies");
        keysToSearc.add("berries");

        Iterator<String> iterator = keysToSearc.iterator();
        // iterator()-- return type which we can use with all iterator methods
        // [fruits, veggies, berries]
        while (iterator.hasNext()){  // hasNext it will check every item
            System.out.println(iterator.next()); // it will actually give us
        }
        // print before modification and
        // add * to each string and print again

        Iterator<String> iterator1 = keysToSearc.iterator();
        while (iterator1.hasNext()){
            String item = iterator1.next();
            System.out.println(item);

            System.out.println("*"+ iterator1.next());
        }
        // create a map with <String, String>

        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("Name", "Bryan");
        personalInfo.put("student_id", "234567776543");
        personalInfo.put("major", "computer science");

        Iterator<String > mapIterator = personalInfo.keySet().iterator();
        while (mapIterator.hasNext()){
            String key = mapIterator.next();

            System.out.println(key + personalInfo.get(key));
        }

        // SELENIUM
        /*
        we have 8 locators(element must be unique)
          id - it is unique (it is not always available) we always want to use it when it is avilable
          class - classname
          name
          tag - every element will have a tag

      // only work with the link
          linktext
          partial Linktext

      //locator that us using html (syntax)
          css
          xpath
        */



        /*
        input ---tag
        key= "value" - attributes
        id= "global-enhancements-search-query" --> one of the attributes
        we can use id to locate the element

        name = "search_query" - attribute

        when we find the element it is always be must be unique
        id --> always unique
        name, tag, class---> are not unique very often
                 */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://etsy.com");

        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
        // find element() ---> returns WebElement
        // as param we put By.locator("value of attribute")
        // (id, name, classname , class, .....)
    }
}
