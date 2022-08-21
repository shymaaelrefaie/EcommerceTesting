@smoke
Feature: User should be able to register to the system

  Scenario: User register with valid data
  Given user navigates to register page

    When user enter all valid data
    And user click on register button

    Then Confirmation Screen displayed
    And success message displayed
    And success message color is green