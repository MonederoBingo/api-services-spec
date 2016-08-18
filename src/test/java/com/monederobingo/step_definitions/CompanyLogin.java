/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompanyLogin {

    private final ServiceResultHolder serviceResultHolder;

    public CompanyLogin(ServiceResultHolder serviceResultHolder) {
        this.serviceResultHolder = serviceResultHolder;
    }

    @Given("^User provides correct company login information$")
    public void userProvidesCorrectCompanyLoginInformation() {
    }

    @Given("^The user should be active$")
    public void theUserShouldBeActive() {
        assertTrue(serviceResultHolder.getJSONObject().getBoolean("isActive"));
    }

    @And("^The user should not need to change password$")
    public void theUserShouldNotNeedToChangePassword() throws Throwable {
        assertFalse(serviceResultHolder.getJSONObject().getBoolean("mustChangePassword"));
    }
}
