Feature: Unsuccessful Company Registration
  Scenario: User provides incorrect company name
    Given User provides empty company name
    When User sends registration request
    Then The response should be not successful
    And The user should receive a message the following messages
      | ENGLISH | Specify the company name |
      | SPANISH | Indique el nombre de la compañía |
