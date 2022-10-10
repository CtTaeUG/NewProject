Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario: States testing with JDBC
    And Click on the element in the laft nav
      | setupOne |
      | parameters |
      | states |
    Then Send The query