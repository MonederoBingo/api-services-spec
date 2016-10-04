@authenticated_company_action
Feature: Promotion configuration

  Scenario: User gets default promotion configuration
    Given User sends get promotion configuration request
    Then The user should get 1000 required points