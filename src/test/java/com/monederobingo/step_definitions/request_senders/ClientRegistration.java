/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

public class ClientRegistration implements En {

    public ClientRegistration(ServiceResultHolder serviceResultHolder, ClientRegistrationRequest clientRegistrationRequest) {
        When("^User sends client registration request$", () ->
                serviceResultHolder.set(clientRegistrationRequest.send())
        );
    }
}
