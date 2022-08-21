@smoke
Feature: User should be able to select Euro currency

  Scenario: User select currency

  Given user navigates to home page
  When user select euro from dropdownlist

  Then user display item with euro currency
