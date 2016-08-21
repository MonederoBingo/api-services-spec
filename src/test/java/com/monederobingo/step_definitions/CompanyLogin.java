/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompanyLogin implements En {

    public CompanyLogin(ServiceResultHolder serviceResultHolder) {
        Given("^User provides correct company login information$", () -> {
        });
        Given("^The user should be active$", () -> {
            assertTrue(serviceResultHolder.getJSONObject().getBoolean("isActive"));
        });
        And("^The user should not need to change password$", () -> {
            assertFalse(serviceResultHolder.getJSONObject().getBoolean("mustChangePassword"));
        });
    }
}
