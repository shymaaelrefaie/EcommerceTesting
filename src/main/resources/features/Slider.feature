@smoke
Feature: User should be able to click on slider

  Scenario: User open Nokia slider
    Given user click on slider nokia
    Then system should open in new tab in URL "Nokia1020"


  Scenario: User open Iphone slider
    Given user click on slider iphone
    Then system should open in new tab in URL "Iphone"
