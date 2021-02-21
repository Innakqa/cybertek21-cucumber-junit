package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Etsy_StepDefinitions {

    EtsySearchPage etsySearchPage = new EtsySearchPage();


    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {

        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);

    }

    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {

        String actual = Driver.getDriver().getTitle();
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertTrue(actual.equals(expected));
    }


    @And("user searches for {string} in the search box")
    public void userSearchesForInTheSearchBox(String arg0) {

        etsySearchPage.searchBox.sendKeys(arg0 + Keys.ENTER);

    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String arg0) {

        String actual = Driver.getDriver().getTitle();
        String expected = arg0+" | Etsy";

        //Assert.assertTrue(actual.contains(expected));
        Assert.assertTrue(actual.equals(expected));



    }

    @And("user searches for wooden spoon in the search box")
    public void userSearchesForWoodenSpoonInTheSearchBox() {
        etsySearchPage.searchBox.sendKeys("wooden spoon"+Keys.ENTER);
    }

    @Then("user should see Wooden spoon in the title")
    public void userShouldSeeWoodenSpoonInTheTitle() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Wooden spoon";

        Assert.assertTrue(actual.contains(expected));
    }


}
