@authenticated_company_action
Feature: Getting promotions available by client
  Background:
    Given User sends points awarding request with phone number "6661234567" and 1000 amount

  Scenario: User gets promotions successfully
    Given User sends request to get promotions available by client with phone number "6661234567"
    Then The response should be successful
    And The response should contain one promotion
    And Response should have companyId
    And Response should have promotionConfigurationId
    And The promotion should have 1000 required points
    And The promotion should have this description: "10% off in your next purchase!"