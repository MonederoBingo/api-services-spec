Feature: Registering new company
  Scenario: Non existent company user provides correct information
    Given User provides correct registration information
    When User sends registration request
    Then The user should receive a message reporting that was successfully added
