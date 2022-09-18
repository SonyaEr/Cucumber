Feature: Smoke
  As a user
  I want to test website's main functionality and make sure that site works correctly

  Scenario Outline: Check login
    Given I open '<homePage>' page
    When I click 'Sign In' button
    And I check sign in field visibility on sign in page
    And I fill in sign in field by keyword '<email>'
    And I click 'Sign in Continue' button
    And I check password field visibility on sign in page
    And I fill in password field by keyword '<password>'
    And I click 'Sign in Submit' button
    Then I check that user title contains '<name>'

    Examples:
      | homePage                | email                       | password            | name            |
      | https://www.amazon.com/ | yeroshenko.sofia@gmail.com  | Ye*JL)rwF!hN3Be     | Sofia           |

  Scenario Outline: Check search list
    Given I open '<homePage>' page
    When I click 'Nav Search List' button
    And I check search options on header
    And I click search option by keyword '<keyword>'
    And I click 'Search' button
    Then I compare current search option with '<keyword>' on header
    And I check that url contains query of search option

    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | Computers  |

  Scenario Outline: Check search
    Given I open '<homePage>' page
    And I check search field visibility on header
    When I make search by keyword '<keyword>'
    Then I compare current search input with '<keyword>' on header
    And I check that url contains '<keyword>'

    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | Computers  |

  Scenario Outline: Check add product to cart with price
    Given I open '<homePage>' page
    And I check search field visibility on header
    When I make search by keyword '<keyword>'
    And I check image of product visibility
    And I click Image on product with price
    And I click 'Add to Cart' button on product
    Then I check that cart title is '<title>'
    And I check 'count cart' visibility
    And I check 'proceed to checkout' visibility
    And I compare 'count cart' with 'proceed to checkout'
    And I check 'price count' visibility
    And I check 'price nav flyout' visibility
    And I compare 'price cart' with 'price nav flyout'


    Examples:
      | homePage                | keyword     | title         |
      | https://www.amazon.com/ | playstation | Added to Cart |
