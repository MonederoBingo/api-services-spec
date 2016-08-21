/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

public class CompanyRegistration implements En {

    public CompanyRegistration(ServiceResultHolder serviceResultHolder, CompanyRegistrationRequest companyRegistrationRequest) {
        When("^User sends company registration request$", () -> {
            serviceResultHolder.set(companyRegistrationRequest.send());
        });
        And("^User sends activation request$", () -> {
            new ActivateCompanyUserRequest().send(serviceResultHolder.get().getExtraInfo());
        });
    }
}
