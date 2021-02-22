package com.cybertek.utilities;
/*
We will create utility methods for repeated steps that can be used in browsers, and store in class.
 */

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


    /*
    This method accepts List<WebElement> and returns List<Strings>
     */

    public static List<String> getElementText(List<WebElement> webElementList) {

//Placeholder empty list of web element
        List<String> webElementsAsString = new ArrayList<>();
//Looping through list of web elements and storing text into placeholder list
        for (WebElement each : webElementList) {
            webElementsAsString.add(each.getText());
        }
        //returning final List<String>
        return webElementsAsString;
    }


    /*    Method to assert title */
    ////         boolean
    public static void titleVerification(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));

        //// return actualTitle.equals(expectedTitle) ////and with boolean no Assert is needed
    }

    /*create method name: wait
      converting milliseconds to seconds
      handle checked exception
     */
    public static void wait(int second) {

        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("smth happened in sleep method");
        }
    }

}


// utility classes/methods for smaller sections of my test automation: login, logout, etc