@authenticated_company_action
Feature: Award points to client

  Scenario: Awarding points to client successfully
    Given User sends points awarding request with phone number "6661234567", 100 amount and sale key "ABC"
    Then The response should have "100.0" as object
    And The user should receive the following messages
      | ENGLISH | Points awarded: 100.0 |
      | SPANISH | Puntos otorgados: 100.0 |

  Scenario: Missing sale key
    Given User sends points awarding request with phone number "6661234567", 100 amount and sale key ""
    Then The user should receive the following messages
      | ENGLISH | You should specify a sale key |
      | SPANISH | Indique el número de venta. |

  Scenario: Existing sale key
    Given User sends points awarding request with phone number "6661234567", 100 amount and sale key "ABC"
    And User sends points awarding request with phone number "6661234567", 100 amount and sale key "ABC"
    Then The user should receive the following messages
      | ENGLISH | Sale key already exists. |
      | SPANISH | El número de venta ya existe. |

  Scenario: Short phone number
    Given User sends points awarding request with phone number "1234", 100 amount and sale key "ABC"
    Then The user should receive the following messages
      | ENGLISH | Phone must have 10 digits. |
      | SPANISH | El número de teléfono debe tener al menos 10 dígitos. |

  Scenario: Invalid phone number
    Given User sends points awarding request with phone number "INVALID", 100 amount and sale key "ABC"
    Then The user should receive the following messages
      | ENGLISH | Phone must have 10 digits. |
      | SPANISH | El número de teléfono debe tener al menos 10 dígitos. |