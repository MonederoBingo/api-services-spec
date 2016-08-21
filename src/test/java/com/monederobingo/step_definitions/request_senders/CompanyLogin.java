/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.login.CompanyLoginRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

public class CompanyLogin implements En {

    public CompanyLogin(ServiceResultHolder serviceResultHolder, CompanyLoginRequest companyLoginRequest) {
        When("^User sends company login request$", () ->
                serviceResultHolder.set(companyLoginRequest.send())
        );
    }
}
