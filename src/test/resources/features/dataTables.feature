Feature: Simple examples of how dataTables work


  Scenario: Something happens
    #Given User does something
    Then User should see below words displayed
      | Apple      |
      | Kiwi       |
      | Orange     |
      | Broccoli   |
      | Watermelon |



  # To organize pipes: Ctrl + Alt + L
  # ctrl + D




  #TC#27: SmartBear order process
  #Note: Follow POM
  @dataTable
  Scenario: User should be able to login with correct credentials
    Given User is on the login page of SmartBear
    When User enters below info
      | username | Tester |
      | password | test   |
    Then User should see title changed to Web Orders
