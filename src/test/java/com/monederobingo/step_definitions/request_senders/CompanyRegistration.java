/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class CompanyRegistration {
    private final ServiceResultHolder serviceResultHolder;
    private final CompanyRegistrationRequest companyRegistrationRequest;

    public CompanyRegistration(ServiceResultHolder serviceResultHolder, CompanyRegistrationRequest companyRegistrationRequest) {
        this.serviceResultHolder = serviceResultHolder;
        this.companyRegistrationRequest = companyRegistrationRequest;
    }

    @When("^User sends company registration request$")
    public void userSendCompanyRegistrationRequest() throws Throwable {
        serviceResultHolder.set(companyRegistrationRequest.send());
    }

    @And("^User sends activation request$")
    public void userSendsActivationRequest() throws Throwable {
        new ActivateCompanyUserRequest().send(serviceResultHolder.get().getExtraInfo());
    }
}
