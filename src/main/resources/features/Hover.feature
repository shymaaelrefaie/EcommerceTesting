@smoke
Feature: users could hover Categories and select one of sub category successfully

  Scenario: user can hover on one categories then click on sub category

    Given user hover on one category
    When user can view sub-category
    Then user can select sub category
