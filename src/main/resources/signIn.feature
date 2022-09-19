Feature: Sign In
  As a user
  I'd like to sign in to website

  Background:
    Given I open 'https://www.amazon.com/' page
    When I click 'Sign In' button
    And I check sign in field visibility on sign in page

  Scenario Outline: Check login
    And I fill in sign in field by keyword '<email>'
    And I click 'Sign in Continue' button
    And I check password field visibility on sign in page
    And I fill in password field by keyword '<password>'
    And I click 'Sign in Submit' button
    Then I check that user title contains '<name>'

    Examples:
       | email                      | password        | name  |
       | yeroshenko.sofia@gmail.com | Ye*JL)rwF!hN3Be | Sofia |

  @NegativeTestCase
  Scenario Outline: Check email error in sign in
    And I fill in sign in field by keyword '<error keyword>' and enter
    Then I check error or warning visibility on sign in page

    Examples:
      | error keyword |
      | 12H           |

  @NegativeTestCase
  Scenario Outline: Check password error in sign in
    And I fill in sign in field by keyword '<keyword>' and enter
    And I check password field visibility on sign in page
    And I fill in password field by keyword '<password>' and enter
    Then I check error or warning visibility on sign in page

    Examples:
      | keyword        | password |
      | user@gmail.com | 5555     |