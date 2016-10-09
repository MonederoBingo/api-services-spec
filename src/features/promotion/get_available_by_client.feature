@authenticated_company_action
Feature: Getting promotions available by client

  Scenario: User gets promotions successfully
    Given User sends points awarding request with phone number "6661234567", 1000 amount and sale key "ABC"
    And User sends request to get promotions available by client with phone number "6661234567"
    Then The response should be successful
    And The response should contain one promotion
    And The response should have companyId
    And The response should have promotionConfigurationId
    And The promotion should have 1000 required points
    And The promotion should have this description: "10% off in your next purchase!"

  Scenario: No enough points for any promotion
    Given User sends points awarding request with phone number "6661234567", 10 amount and sale key "ABC"
    And User sends request to get promotions available by client with phone number "6661234567"
    Then The user should receive the following messages
      | ENGLISH | Client does not have available promotions. |
      | SPANISH | El cliente no alcanza ninguna promoción. |

  Scenario: Phone number does not exist
    Given User sends request to get promotions available by client with phone number "6661234567"
    Then The user should receive the following messages
      | ENGLISH | Phone number does not exist. |
      | SPANISH | El número de teléfono no existe. |