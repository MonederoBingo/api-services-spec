Feature: Unsuccessful Company Login
  Background:
    Given User sends company registration request

  Scenario: User provides correct information
    Given User provides correct company login information
    When User sends company login request
    Then The response should be not successful
    And The user should receive the following messages
      | ENGLISH | You user is not active, please verify your email and click on the activation link. |
      | SPANISH | Su usuario no esta activo, favor de verificar su correo y dar clic en el link de activación. |
