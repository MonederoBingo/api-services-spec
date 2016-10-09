@authenticated_company_action
Feature: Applying promotion to client

  Scenario: Applying promotion to client successfully
    Given User sends points awarding request with phone number "6661234567" and 1000 amount
    And User sends request to get promotions available by client with phone number "6661234567"
    And User sends request to apply promotion to phone number "6661234567"
    Then The response should be successful
    And The user should receive the following messages
      | ENGLISH | Promotion applied. |
      | SPANISH | Promoción aplicada. |

  Scenario: Not enough points
    Given User sends points awarding request with phone number "6661234567" and 10 amount
    And User sends request to get promotions available by client with phone number "6661234567"
    Then The response should be successful
    And The user should receive the following messages
      | ENGLISH | Client does not have available promotions. |
      | SPANISH | El cliente no alcanza ninguna promoción. |

  Scenario: Not existing phone number
    Given User sends request to get promotions available by client with phone number "6661234567"
    And The user should receive the following messages
      | ENGLISH | Phone number does not exist. |
      | SPANISH | El número de teléfono no existe. |