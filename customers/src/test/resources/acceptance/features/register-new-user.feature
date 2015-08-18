Feature: New user registration
  As an api client
  I want to register a new user

  Scenario: Register a new user
    Given I have provided the email test@testdomain.com
    When I submit the request
    Then I receive a response STATUS 200 (OK)
    And the json with the contents of the new customer

  Scenario: Register with an already registered email
    Given I have provided the email test@testdomain.com
    And the provided email is already in use
    When I submit the request
    Then I receive the response STATUS 409 (Conflict)
    And a message body stating that the resource already exists