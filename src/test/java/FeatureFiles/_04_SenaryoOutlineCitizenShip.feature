Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship page

  Scenario Outline: Citizenship creation
    When User creates a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
    Then Success message should be displayed

    When User creates a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
    Then Already exists message should be displayed
    And Click on close button

    When User deletes the "<CitizenshipName>"
    Then Success message should be displayed

    Examples:
      | CitizenshipName | ShortName |
      | Citizen10191    | ctz1911   |
      | Citizen20292    | ctz2922   |









