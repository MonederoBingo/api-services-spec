@authenticated_company_action
Feature: Register company user

  Scenario: Register user successfully
    Given User sends company user registration request
    And The user should receive the following messages
      | ENGLISH | The user was successfully added. |
      | SPANISH | El usuario fue agregado exitosamente. |