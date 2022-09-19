Feature: Smoke
  As a user
  I want to test website's main functionality and make sure that site works correctly

  Background:
    Given I open 'https://www.amazon.com/' page

  Scenario Outline: Check search list
    When I click 'Nav Search List' button
    And I check search options on header
    And I click search option by keyword '<keyword>'
    And I click 'Search' button
    Then I compare current search option with '<keyword>' on header
    And I check that url contains query of search option

    Examples:
      | keyword   |
      | Computers |

  Scenario Outline: Check search
    And I check search field visibility on header
    When I make search by keyword '<keyword>'
    Then I compare current search input with '<keyword>' on header
    And I check that url contains '<keyword>'

    Examples:
      | keyword   |
      | Computers |

  Scenario Outline: Check add product to cart with price
    And I check search field visibility on header
    When I make search by keyword '<keyword>'
    And I check image of product visibility
    And I click image on product with price
    And I save 'price product'
    And I click 'Add to Cart' button on product
    Then I check that cart title is '<title>'
    And I check 'count cart' visibility
    And I check 'proceed to checkout' visibility
    And I compare 'price cart' with 'price product'
    And I compare 'count cart' with 'proceed to checkout'
    And I check 'price cart' visibility
    And I check 'price nav flyout' visibility
    And I compare 'price cart' with 'price nav flyout'

    Examples:
      | keyword     | title         |
      | playstation | Added to Cart |

  Scenario Outline: Check add to checkout page
    And I check search field visibility on header
    When I make search by keyword '<keyword>'
    And I check image of product visibility
    And I click image on product with price
    And I click 'Add to Cart' button on product
    And I click 'Go to Cart' button on product
    And I click 'Proceed to checkout' button on product
                     # Sign in #
    And I check sign in field visibility on sign in page
    And I fill in sign in field by keyword '<email>'
    And I click 'Sign in Continue' button
    And I check password field visibility on sign in page
    And I fill in password field by keyword '<password>'
    And I click 'Sign in Submit' button
                     #        #
    Then I check that checkout page contains '<title>'


    Examples:
      | keyword     | title                     | email                      | password        |
      | playstation | Select a shipping address | yeroshenko.sofia@gmail.com | Ye*JL)rwF!hN3Be |

  Scenario Outline: Check filter price
    When I click category by keyword '<keyword>'
    And I click first price category
    And I fill in low price field by keyword '<lowPrice>'
    And I fill in high price field by keyword '<highPrice>'
    And I click 'Submit price'
    Then I compare prices on page within '<lowPrice>' and '<highPrice>'

    Examples:
      | keyword     | lowPrice  | highPrice   |
      | Video Games | 5         | 10          |

  Scenario Outline: Check changing price
    When I click 'Nav Search List' button
    And I check search options on header
    And I click search option by keyword '<keyword>'
    And I click 'Search' button
    And I click 'Reviews' button by '<name>'
    Then I checks that product page contains 'Customer reviews'

    Examples:
      | keyword     | name   |
    # | Video Games | PS5
      |Pet Supplies |Meow |

