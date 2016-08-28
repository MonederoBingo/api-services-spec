package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import cucumber.api.java8.En;

public class ClientRegistration implements En {

     public ClientRegistration(ClientRegistrationRequest clientRegistrationRequest) {

        Given("^User provides correct client registration information$", () -> {
        });

         Given("^User provides existent phone number$", () -> {
            clientRegistrationRequest.withPhoneNumber("5551234567").send();
            clientRegistrationRequest.withPhoneNumber("5551234567");
        });

         Given("^User provides the phone number \"([^\"]*)\"$",
                 clientRegistrationRequest::withPhoneNumber);
    }
}
