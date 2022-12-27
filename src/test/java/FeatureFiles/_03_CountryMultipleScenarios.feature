Feature: Country multi Scenario

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country page
@Regression
    Scenario: Creating a country
      When Create a country
      Then Success message should be displayed
@Regression
    Scenario: Creating a country  with parameter data
      When Create a country name as "HYXY1" code as "codeE191"
      Then Success message should be displayed
      And Delete the "HYXY1"





