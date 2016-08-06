/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.step_definitions.domain_holders.AuthRequestHolder;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.When;

public class RequestSender
{
    private final ServiceResultHolder serviceResultHolder;
    private final AuthRequestHolder authRequestHolder;

    public RequestSender(ServiceResultHolder serviceResultHolder, AuthRequestHolder authRequestHolder)
    {
        this.serviceResultHolder = serviceResultHolder;
        this.authRequestHolder = authRequestHolder;
    }

    @When("^User sends registration request$")
    public void userSendRegistrationRequest() throws Throwable
    {
        serviceResultHolder.set(authRequestHolder.get().send());
    }
}
