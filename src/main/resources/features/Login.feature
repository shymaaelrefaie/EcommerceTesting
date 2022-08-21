@smoke
Feature: User should be able to login to the system

  Scenario: User login with valid username and password
    Given user navigates to login page

    When user enter valid username and password

    Then user could login successfully
    And Myaccount menu displayed


  Scenario: User login with invalid username and password
    Given user navigates to login page

    When user enter invalid username and password

    Then user can not login
    And error message displayed
    And error message is red

