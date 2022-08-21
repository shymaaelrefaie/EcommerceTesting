@smoke
Feature: users can search functionality to get product successfully

  Scenario Outline: user can search with product-name
    Given user search with "<Keyword>" and get search result
    When user get search result on valid page
    Then user find each result contains the search word by keyword "<Keyword>"
    Examples:
      | Keyword |
      | book    |
      | nokia  |
      | nike    |

  Scenario Outline: user can search with product-name using sku
    Given user search with "<sku>" and get search result
    When user click on product in search result
    Then user find each result contains word by sku "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
      | AP_MBP_13 |

