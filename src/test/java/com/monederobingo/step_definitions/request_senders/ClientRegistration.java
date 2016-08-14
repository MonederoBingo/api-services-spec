/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.When;

public class ClientRegistration {
    private final ServiceResultHolder serviceResultHolder;
    private final ClientRegistrationRequest clientRegistrationRequest;

    public ClientRegistration(ServiceResultHolder serviceResultHolder, ClientRegistrationRequest clientRegistrationRequest) {
        this.serviceResultHolder = serviceResultHolder;
        this.clientRegistrationRequest = clientRegistrationRequest;
    }

    @When("^User sends client registration request$")
    public void userSendsClientRegistrationRequest() throws Throwable {
        serviceResultHolder.set(clientRegistrationRequest.send());
    }
}
