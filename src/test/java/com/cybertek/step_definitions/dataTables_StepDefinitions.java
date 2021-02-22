package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class dataTables_StepDefinitions {

    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();


    @Then("User should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> fruitList) {

        System.out.println("fruitList.size() = " + fruitList.size()); //fruitList.size() = 5

        System.out.println("fruitList = " + fruitList); //fruitList = [Apple, Kiwi, Orange, Broccoli, Watermelon]

        for (String eachFruit : fruitList) {
            System.out.println("eachFruit = " + eachFruit);
        }
        /*
        eachFruit = Apple
        eachFruit = Kiwi
        eachFruit = Orange
        eachFruit = Broccoli
        eachFruit = Watermelon
         */

    }

    @Given("User is on the login page of SmartBear")
    public void user_is_on_the_login_page_of_smart_bear() {

        String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);
    }


    @When("User enters below info")
    public void user_enters_below_info(Map<String, String> loginInfo) {

        /* Map LoginInfo
          username = Tester
          password = test
         */

        String userName = loginInfo.get("username"); // will return Tester
        String password = loginInfo.get("password"); // will return test

        smartBearLoginPage.loginToSmartBear(userName, password);

    }

    @Then("User should see title changed to Web Orders")
    public void user_should_see_title_changed_to_web_orders() {

        BrowserUtils.titleVerification("Web Orders");

    }


    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {

        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");

    }


//---------------------------DropDown Practice / DataTable

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {

        String actualList =

    }


}
