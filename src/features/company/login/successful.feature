Feature: Successful Company Login
  Background:
    Given User sends company registration request
    And User sends activation request

  Scenario: User provides correct information
    Given User provides correct company login information
    When User sends company login request
    Then The response should be successful
    And The user should be active
    And The user should not need to change password
