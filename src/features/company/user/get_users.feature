@authenticated_company_action
Feature: Get company users list
  A user is automatically created when registering company

  Scenario: Get list successfully
    Given User sends company registration request with name "Username1" and email "username1@monederobingo.com"
    And User sends company user listing request
    Then The response should have 2 rows
    And both users should have same companyId
    And user "Username1" should be inactive
    And user "Username1" should have email "username1@monederobingo.com"