Feature: Sleek Test Cases

  @TC01
  Scenario: Clicking the Pricing link from the Header menu navigates user to the Pricing page
    Given I go to the Sleek SG Home page
    When I click on the "Pricing" link
    Then I should be navigated to the Sleek SG "Pricing" page

  @TC02
  Scenario Outline: Correct corporate secretary details should display after updating accounting progress line
    Given I am on the Sleek SG "Pricing" page
    When I click learn more button for "Corporate secretary" on pricing page
    And I select "<noShareholders>" in dropdown "Number of shareholders" on corporate secretary page
    Then Verify corporate secretary details are correct: "<noShareholders>" "<pricePerYear>"

    Examples:
      | noShareholders     | pricePerYear |
      | 2 Shareholders     | S$360/year   |
      | 6 - 9 Shareholders | S$540/year   |
      | >30 Shareholders   | S$1,140/year |