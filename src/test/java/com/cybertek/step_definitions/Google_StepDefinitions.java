package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Google_StepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Then("User should see the title is Google")
    public void user_should_see_the_title_is_google() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Google";

        Assert.assertTrue(actual.equals(expected));

    }

    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {

        Driver.getDriver().get("https://www.google.com");

    }

    @When("User searches for apple")
    public void user_searches_for_apple() {

        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER); // ===> "apple"

    }

    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    @When("User searches for {string}")
    public void user_searches_for(String string) {

        googleSearchPage.searchBar.sendKeys(string + Keys.ENTER);  // ===> string - parameter

    }

    @Then("User should see {string} in the title")
    public void user_should_see_in_the_title(String string) {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string;                                          // ===> string - parameter

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    @Then("User should see following links")
    public void user_should_see_following_links(List<String> expectedFooterLinks) {

        System.out.println("footerLinks = " + expectedFooterLinks); // print out the values
                                                                   // footerLinks = [Advertising, Business, How Search works, Privacy, Terms]

        for (WebElement eachLink : googleSearchPage.footerLinks) {
            System.out.println("eachLink = " + eachLink.getText());
        }
        /*
        eachLink = Advertising
        eachLink = Business
        eachLink = How Search works
        eachLink = Privacy
        eachLink = Terms
         */

//        //Create a List of strings (as place holder)
//        //Loop through List of WebElements, pass all text into place holder list
//        //Then compare 2 List if Strings: actual vs expected
//
        List<String> actualFooterLinks = new ArrayList<>();

        for (WebElement eachLink : googleSearchPage.footerLinks) {
            actualFooterLinks.add(eachLink.getText());
        }
        Assert.assertEquals(actualFooterLinks, expectedFooterLinks);

    }

}
