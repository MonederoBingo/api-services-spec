Feature: Successful Company Activation

  Background:
    Given User sends company registration request

  Scenario: User provides correct activation key
    When User sends activation request
    Then The response should be successful
