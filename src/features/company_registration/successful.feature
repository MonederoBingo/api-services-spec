Feature: Successful Company Registration
  Scenario: User provides correct information
    Given User provides correct registration information
    When User sends registration request
    Then The response should be successful
    And The user should receive a message the following messages
      | ENGLISH | We've sent you an email. Open it up to activate your account. If you do not receive that email within 1 hour, please email support@monederobingo.com |
      | SPANISH | Se ha enviado un link de activación a su correo. Si no lo recibe dentro de una hora, favor de enviar un correo a support@monederobingo.com |
