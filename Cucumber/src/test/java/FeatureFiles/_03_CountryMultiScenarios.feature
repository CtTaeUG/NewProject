Feature: Country Multi Scenario

  Scenario: Create a country
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario: Create a country parameter data
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to basqar
    When Create a country parameter