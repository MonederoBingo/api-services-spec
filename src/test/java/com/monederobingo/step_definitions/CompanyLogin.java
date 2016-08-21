/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.login.CompanyLoginRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompanyLogin implements En {

    public CompanyLogin(ServiceResultHolder serviceResultHolder,
                        CompanyRegistrationRequest companyRegistrationRequest,
                        CompanyLoginRequest companyLoginRequest) {

        Given("^User provides correct company login information$", () -> {
            companyRegistrationRequest
                    .withEmail("test@monederobingo.com")
                    .andPassword("password");
        });

        Given("^The user should be active$", () -> {
            assertTrue(serviceResultHolder.getJSONObject().getBoolean("isActive"));
        });

        Given("^The user should not be active$", () -> {
            assertFalse(serviceResultHolder.getJSONObject().getBoolean("isActive"));
        });

        And("^The user should not need to change password$", () -> {
            assertFalse(serviceResultHolder.getJSONObject().getBoolean("mustChangePassword"));
        });

        But("^User provides wrong email$", () -> {
            companyLoginRequest.withEmail("different@email.com");
        });

        But("^User provides wrong password$", () -> {
            companyLoginRequest.withPassword("different_password");
        });
    }
}
