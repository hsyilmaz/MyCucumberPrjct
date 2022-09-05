Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship page

      Scenario: Creating citizenship from Excel
        When User Creates citizenship with apachePOI

      Scenario: Deleting citizenship from Excel
        Then  User Deletes citizenship with apachePOI