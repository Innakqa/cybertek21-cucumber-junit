Feature:Google search functionality
  Agile Story: As a user, when I am on the google search
  page, I should be able to search whatever
  I want, and see relevant information

  #@wip #work in progress - smth I`m currently working on
  Scenario: Search page title verification
    Given User is on Google home page
    Then User should see the title is Google


  Scenario: User search title verification
    Given User is on Google home page
    When User searches for apple
    Then User should see apple in the title

  @wip
  Scenario: User search title verification
    Given User is on Google home page
    When User searches for "apple"
    Then User should see "apple" in the title


#alt + enter is not working
  @googleDataTable
  Scenario: Google home page footer links verification
    Given User is on Google home page
    Then User should see following links
      | Advertising      |
      | Business         |
      | How Search works |
      | Privacy          |
      | Terms            |


