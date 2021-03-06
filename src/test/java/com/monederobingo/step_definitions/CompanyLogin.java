
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.login.CompanyLoginRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompanyLogin implements En {

    public CompanyLogin(ServiceResultHolder serviceResult,
                        CompanyRegistrationRequest companyRegistrationRequest,
                        CompanyLoginRequest companyLoginRequest) {

        Given("^User provides correct company login information$", () ->
                companyRegistrationRequest
                        .withEmail("test@monederobingo.com")
                        .andPassword("password"));

        Given("^The user should be active$", () ->
                assertTrue(serviceResult.getJSONObject().getBoolean("active")));

        Given("^The user should not be active$", () ->
                assertFalse(serviceResult.getJSONObject().getBoolean("active")));

        And("^The user should not need to change password$", () ->
                assertFalse(serviceResult.getJSONObject().getBoolean("mustChangePassword")));

        But("^User provides wrong email$", () ->
                companyLoginRequest.withEmail("different@email.com"));

        But("^User provides wrong password$", () ->
                companyLoginRequest.withPassword("different_password"));
    }
}
