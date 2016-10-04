Feature: Unsuccessful Company Activation

  Background:
    Given User sends company registration request

  Scenario: User provides incorrect activation key
    When User sends wrong activation request
    Then The response should not be successful
    And The user should receive the following messages
      | ENGLISH | :/ We are very sorry, there was an error. We're trying to solve it. You can email us to support@monederobingo.com if you want to be updated about this. |
      | SPANISH | :/ Los sentimos, hubo un error. Estamos tratando de resolverlo, puede enviarnos un correo a support@monederobingo.com si desea saber mas al respecto. |
