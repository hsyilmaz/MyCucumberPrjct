Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    When Click on the element in the Left Nav
      | setupOne   |
      | parameters |
      | states     |
    Then Send The query the database "select * from States" and control match