package com.cybertek.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Library_StepDefinitions {


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page.");

    }


    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters LIBRARIAN username");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters LIBRARIAN password");
        //Intentionally failing this step
        //Assert.fail("Intentional FAIL!");
    }


    @Then("user should see dashboard")
    public void userShouldSeeDashboard() {
        System.out.println("User sees dashboard");
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        System.out.println("User enters STUDENT username");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        System.out.println("User enters STUDENT password");
    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("User enters ADMIN username");
    }

    @And("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("User enters ADMIN password");
    }
}
