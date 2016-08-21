Feature: Unsuccessful Company Login
  Background:
    Given User sends company registration request

  Scenario: User provides correct information
    Given User provides correct company login information
    When User sends company login request
    Then The response should not be successful
    And The user should not be active
    And The user should receive the following messages
      | ENGLISH | You user is not active, please verify your email and click on the activation link. |
      | SPANISH | Su usuario no esta activo, favor de verificar su correo y dar clic en el link de activación. |

  Scenario: User provides wrong email
    Given User sends activation request
    But User provides wrong email
    When User sends company login request
    Then The response should not be successful
    And The user should receive the following messages
      | ENGLISH | Login failed! Please verify your information. |
      | SPANISH | No se pudo iniciar sesión, verifique su correo y contraseña. |

  Scenario: User provides wrong password
    Given User sends activation request
    But User provides wrong password
    When User sends company login request
    Then The response should not be successful
    And The user should receive the following messages
      | ENGLISH | Login failed! Please verify your information. |
      | SPANISH | No se pudo iniciar sesión, verifique su correo y contraseña. |
