Feature: navigation test

  @only
  Scenario: basic test for lemonade app
    Given I am on lemon tree screen
    When I click on lemon tree
    Then lemons should be available
    When I click on lemon for full squeeze
    Then lemonade should be available
    When I click on lemonade to drink
    Then glass should be empty
