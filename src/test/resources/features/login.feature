@1
Feature: Library app login
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: User is already in login page
    Given user is on the login page

  @Librarian @employee
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see dashboard

  @Student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see dashboard

  #@wip
  @Admin @employee
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see dashboard


  #hover over the line -> ctrl + enter


  #WINDOWS: alt + enter

  #comment in the feature file


#