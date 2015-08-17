Feature: New user registration
  As a user
  I want to register

  Scenario: Register as a new user
    Given I have provided the email test@testdomain.com
    When I press register
    Then I receive a new registration email to the provided mail
    And a new inactive user is register

  Scenario: Register with an already registered email
    Given I have provided the email test@testdomain.com
    And the provided email is already in use
    When I press register
    Then a warning is shown that the email is already in use
    And no new user is register