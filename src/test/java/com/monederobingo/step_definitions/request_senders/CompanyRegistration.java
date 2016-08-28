/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;
import cucumber.api.java8.StepdefBody.A0;

public class CompanyRegistration implements En {

    public CompanyRegistration(ServiceResultHolder holder,
                               CompanyRegistrationRequest companyRegistrationRequest,
                               ActivateCompanyUserRequest activateCompanyUserRequest) {

        When("^User sends company registration request$",
                (A0) companyRegistrationRequest::send);

        And("^User sends activation request$",
                () -> activateCompanyUserRequest.send(holder.get().getExtraInfo()));
    }
}
