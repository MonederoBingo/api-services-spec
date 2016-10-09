@authenticated_company_action
Feature: Getting Default Promotion configuration

  Scenario: User gets default promotion configuration
    Given User sends get promotion configuration request
    Then Response should have only one configuration
    And The response should have companyId
    And The response should have promotionConfigurationId
    And The configuration should have 1000 required points
    And The configuration should have this description: "10% off in your next purchase!"