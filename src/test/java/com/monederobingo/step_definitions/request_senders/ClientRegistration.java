package com.monederobingo.step_definitions.request_senders;

import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

import static cucumber.api.java8.StepdefBody.A0;

public class ClientRegistration implements En {

    public ClientRegistration(ServiceResultHolder serviceResultHolder,
                              ClientRegistrationRequest clientRegistrationRequest) {

        When("^User sends client registration request$",
                (A0) clientRegistrationRequest::send
        );
    }
}
