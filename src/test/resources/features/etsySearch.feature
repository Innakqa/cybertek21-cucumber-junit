Feature: Etsy search feature

  //Background:


  Scenario: Etsy default title verification
    Given user is on the Etsy landing page
    Then user should see Etsy title as expected

    #expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
  @etsy
  Scenario: Etsy Search title verification
    Given user is on the Etsy landing page
    And user searches for "wooden spoon" in the search box
    Then user should see "Wooden spoon" in the title

    #Wooden Spoon - is parameterized



    Scenario:Etsy Search Title Verification (without parameterization)
      Given user is on the Etsy landing page
      And user searches for wooden spoon in the search box
      Then user should see Wooden spoon in the title


