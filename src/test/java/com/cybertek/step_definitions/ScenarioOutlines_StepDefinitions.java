package com.cybertek.step_definitions;

import com.cybertek.pages.SBear_OrderPage;
import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class ScenarioOutlines_StepDefinitions {

    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage(); // to get the webElements from Page class
    SBear_OrderPage sBearOrderPage = new SBear_OrderPage();


    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrl"));
        smartBearLoginPage.loginToSmartBear();
        sBearOrderPage.orderLink.click();

    }


    @When("User fills out the form as followed from the table below:")
    public void user_fills_out_the_form_as_followed_from_the_table_below() {

    }

    @When("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {

        Select productDropdown = new Select(sBearOrderPage.productDropdown);

       // productDropdown




    }

    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String string) {

    }

    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String string) {

    }

    @When("User enters {string} to street")
    public void user_enters_to_street(String string) {

    }

    @When("User enters {string} to city")
    public void user_enters_to_city(String string) {

    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String string) {

    }

    @When("User enters {string} to zip")
    public void user_enters_to_zip(String string) {

    }

    @When("User selects {string} as card type")
    public void user_selects_as_card_type(String string) {

    }

    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String string) {

    }

    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String string) {

    }

    @When("User clicks process button")
    public void user_clicks_process_button() {

    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String string) {

    }
}
