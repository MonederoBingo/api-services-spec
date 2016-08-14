/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import cucumber.api.java.en.Given;

public class CompanyRegistration {
    private final CompanyRegistrationRequest companyRegistrationRequest;

    public CompanyRegistration(CompanyRegistrationRequest companyRegistrationRequest) {
        this.companyRegistrationRequest = companyRegistrationRequest;
    }

    @Given("^User provides correct company registration information$")
    public void userProvidesCorrectCompanyRegistrationInformation() {
    }

    @Given("^User provides empty company name$")
    public void userProvidesEmptyCompanyName() {
        companyRegistrationRequest.withCompanyName("");
    }

    @Given("^User provides empty email$")
    public void userProvidesEmptyEmail() {
        companyRegistrationRequest.withEmail("");
    }

    @Given("^User provides existent email$")
    public void userProvidesExistentEmail() {
        new CompanyRegistrationRequest().withEmail("same@email.com").send();
        companyRegistrationRequest.withEmail("same@email.com");
    }

    @Given("^User provides invalid email$")
    public void userProvidesInvalidEmail() {
        companyRegistrationRequest.withEmail("invalid@email@.com.");
    }

    @Given("^User provides empty language$")
    public void userProvidesEmptyLanguage() {
        companyRegistrationRequest.withLanguage("");
    }

    @Given("^User provides empty password$")
    public void userProvidesEmptyPassword() {
        companyRegistrationRequest.withPassword("");
    }

    @Given("^User provides empty password confirmation$")
    public void userProvidesEmptyPasswordConfirmation() {
        companyRegistrationRequest.withPasswordConfirmation("");
    }

    @Given("^User provides different password confirmation$")
    public void userProvidesDifferentPasswordConfirmation() {
        companyRegistrationRequest.withPassword("password");
        companyRegistrationRequest.withPasswordConfirmation("different_password");
    }
}
