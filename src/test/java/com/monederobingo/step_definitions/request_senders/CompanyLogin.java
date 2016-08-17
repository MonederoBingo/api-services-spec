/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.login.CompanyLoginRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.When;

public class CompanyLogin {
    private final ServiceResultHolder serviceResultHolder;
    private final CompanyLoginRequest companyLoginRequest;

    public CompanyLogin(ServiceResultHolder serviceResultHolder, CompanyLoginRequest companyLoginRequest) {
        this.serviceResultHolder = serviceResultHolder;
        this.companyLoginRequest = companyLoginRequest;
    }

    @When("^User sends company login request$")
    public void userSendsCompanyLoginRequest() throws Throwable {
        serviceResultHolder.set(companyLoginRequest.send());
    }
}
