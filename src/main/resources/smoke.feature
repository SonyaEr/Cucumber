Feature: Smoke
  As a user
  I want to test website's main functionality and make sure that site works correctly

  Scenario Outline: Check add product to wishlist
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

