Feature: Wikipedia search feature
  As a user,  I should be able to search terms and see related results


  Scenario: Wikipedia search title verification
    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" is in the wiki title

  @wiki
  Scenario: Wikipedia search header verification
    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" in the main header



  Scenario Outline: Wikipedia search header verification
    Given user is on Wikipedia home page
    When user types "<searchValue>" in the wiki search box
    And user clicks wiki search button
    Then user sees "<expectedMainHeader>" in the main header
    Then user sees "<expectedTitle>" is in the wiki title

    Examples: search terms we are going to search in wikipedia
      | searchValue  | expectedMainHeader | expectedTitle |
      | Steve Jobs   | Steve Jobs         | Steve Jobs    |
      | Kuzzat Altay | Kuzzat Altay       | Kuzzat Altay  |
      | Kobe Bryant  | Kobe Bryant        | Kobe Bryant   |
      | Elon Musk    | Elon Musk          | Elon Musk     |
      | Bill Gates   | Bill Gates         | Bill Gates    |
      | Chuck Norris | Chuck Norris       | Chuck Norris  |
      | Marie Curie  | Marie Curie        | Marie Curie   |



# Outline = Template