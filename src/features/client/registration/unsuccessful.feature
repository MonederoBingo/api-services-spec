Feature: Unsuccessful Company Registration

  Scenario: User provides invalid phone number
    Given User provides the phone number "PHONE_NUMBER"
    When User sends client registration request
    Then The response should not be successful
    And The user should receive the following messages
      | ENGLISH | Phone must have 10 digits. |
      | SPANISH | El número de teléfono debe tener al menos 10 dígitos. |

  Scenario: User provides invalid phone number
    Given User provides the phone number "12345"
    When User sends client registration request
    Then The response should not be successful
    And The user should receive the following messages
      | ENGLISH | Phone must have 10 digits. |
      | SPANISH | El número de teléfono debe tener al menos 10 dígitos. |

