/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import cucumber.api.java.en.Given;

public class ClientRegistration {

    private final ClientRegistrationRequest clientRegistrationRequest;

    public ClientRegistration(ClientRegistrationRequest clientRegistrationRequest) {
        this.clientRegistrationRequest = clientRegistrationRequest;
    }

    @Given("^User provides correct client registration information$")
    public void userProvidesCorrectClientRegistrationInformation() {
    }

    @Given("^User provides existent phone number$")
    public void userProvidesExistentPhoneNumber() {
        new ClientRegistrationRequest().withPhoneNumber("5551234567").send();
        clientRegistrationRequest.withPhoneNumber("5551234567");
    }

    @Given("^User provides the phone number \"([^\"]*)\"$")
    public void userProvidesThePhoneNumber(String phoneNumber) {
        clientRegistrationRequest.withPhoneNumber(phoneNumber);    }
}
