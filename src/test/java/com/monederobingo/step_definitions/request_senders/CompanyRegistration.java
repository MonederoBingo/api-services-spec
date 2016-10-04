package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;
import cucumber.api.java8.StepdefBody.A0;

public class CompanyRegistration implements En {

    public CompanyRegistration(ServiceResultHolder serviceResult,
                               CompanyRegistrationRequest companyRegistrationRequest,
                               ActivateCompanyUserRequest activateCompanyUserRequest) {

        When("^User sends company registration request$",
                (A0) companyRegistrationRequest::send);

        And("^User sends activation request$", () ->
                activateCompanyUserRequest.send(serviceResult.get().getExtraInfo()));

        And("^User sends wrong activation request$", () ->
                activateCompanyUserRequest.send("DIFFERENT_ACTIVATION_KEY"));
    }
}
