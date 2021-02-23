Feature: SmartBear order feature

  @scenarioOutline
  Scenario Outline: User ordering a product from Orders page

    Given User is logged into SmartBear Tester account and on Order page
    When User fills out the form as followed from the table below:
    And User selects "<product>" from product dropdown
    And User enters "<quantity>" to quantity
    And User enters "<expectedName>" to costumer name
    And User enters "<street>" to street
    And User enters "<city>" to city
    And User enters "<state>" to state
    And User enters "<zip>" to zip
    And User selects "<cardType>" as card type
    And User enters "<card number>" to card number
    And User enters "<expiration date>" to expiration date
    And User clicks process button
    Then User verifies "<actualName>" is in the list

    Examples:
      | product | quantity | expectedName | street        | city   | state   | zip   | cardType | card number  | expiration date | actualName   |
      | MyMoney | 2        | jamal        | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | jamal        |
      | MyMoney | 2        | umar         | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | umar11       |
      | MyMoney | 2        | livio        | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | livio        |
      | MyMoney | 2        | julia        | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | julia11      |
      | MyMoney | 2        | anna         | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | anna         |
      | MyMoney | 2        | ruslan       | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | ruslan       |
      | MyMoney | 2        | kate         | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | kate         |
      | MyMoney | 2        | chuck norris | 122 london st | london | chelsea | 22150 | visa     | 111111111111 | 12/25           | chuck norris |
