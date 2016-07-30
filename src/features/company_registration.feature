Feature: Registering new company
  Scenario: Non existent company user provides correct information
    Given User provides correct registration information
    When User send registration request
    Then The user should receive a message with message saying that was successfully added
