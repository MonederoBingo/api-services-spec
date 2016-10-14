@authenticated_company_action
Feature: Send sms ad message to client

  Scenario: Send sms message successfully
    Given User sends points awarding request with phone number "6661234567", 100 amount and sale key "ABC"
    And User sends send mobile app advertisement request to phone number "6661234567"
    Then The response should have as extra info "You've got 100 points. Install Monedero Bingo to see our promotions. https://goo.gl/tjyahK"

  Scenario: Send sms message to non-existent client
    When User sends send mobile app advertisement request to phone number "6661234567"
    Then The user should receive the following messages
      | ENGLISH | Phone number does not exist. |
      | SPANISH | El número de teléfono no existe. |