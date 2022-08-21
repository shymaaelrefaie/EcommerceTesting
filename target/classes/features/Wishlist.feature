@smoke
Feature: Add to Wishlist

Scenario: User add product to Wishlist
  Given Navigate to products on homepage
  When user click on wish button of product

  Then Success message displayed
  And Message background color should be green

  Scenario:User verify quantity of Wishlist

    Given Navigate to products on homepage
    When user click on wish button of product

    Then Success message displayed
    And user open wishlist page
    Then user can check the product Qty



