Feature: Successful Client Login

  Background:
    Given User sends client registration request

  Scenario: User provides correct information
    Given User provides correct client login information
    When User sends client login request
    Then The response should be successful
    And The user should should get api key
