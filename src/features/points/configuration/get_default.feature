@authenticated_company_action
Feature: Getting Default Points configuration

  Scenario: User gets default points configuration
    Given User sends get points configuration request
    And The response should be successful
    And The response should have required amount 1
    And The response should have points to earn 1
    And The response should have pointsConfigurationId
    And The response should have companyId