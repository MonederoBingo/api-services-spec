Feature: Unsuccessful Client Login

  Background:
    Given User sends client registration request

  Scenario: User provides invalid phone number
    Given User provides invalid phone number
    When User sends client login request
    Then The response should not be successful
    And The user should receive the following messages
      | ENGLISH | Login failed! Please verify your information. |
      | SPANISH | No se pudo iniciar sesión, verifique su correo y contraseña. |