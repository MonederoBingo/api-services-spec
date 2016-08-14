Feature: Successful Company Registration

  Scenario: User provides correct information
    Given User provides correct client registration information
    When User sends client registration request
    Then The response should be successful

  Scenario: User provides existent phone number
    Given User provides existent phone number
    When User sends client registration request
    Then The response should be successful
