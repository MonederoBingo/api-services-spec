Feature: Unsuccessful Company Registration

  Scenario: User provides empty company name
    Given User provides empty company name
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | Specify the company name |
      | SPANISH | Indique el nombre de la compañía |

  Scenario: User provides empty email
    Given User provides empty email
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | Please specify your email |
      | SPANISH | Ingresa tu correo electrónico |

  Scenario: User provides existent email
    Given User provides existent email
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | This email is already being used on Monedero Bingo. |
      | SPANISH | Este correo ya se esta utilizando en Monedero Bingo. |

  Scenario: User provides invalid email
    Given User provides invalid email
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | Specify a valid email |
      | SPANISH | Indique un email válido |

  Scenario: User provides empty password
    Given User provides empty password
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | Password must have at least 6 characters. |
      | SPANISH | La contraseña debe tener al menos seis caracteres. |

  Scenario: User provides empty password confirmation
    Given User provides empty password confirmation
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | Password and confirmation are different. |
      | SPANISH | La contraseña y la confirmación son diferentes. |

  Scenario: User provides different password confirmation
    Given User provides different password confirmation
    When User sends registration request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | Password and confirmation are different. |
      | SPANISH | La contraseña y la confirmación son diferentes. |
