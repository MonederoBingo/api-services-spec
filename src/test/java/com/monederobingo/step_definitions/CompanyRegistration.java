/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.AuthRequestHolder;
import cucumber.api.java.en.Given;

public class CompanyRegistration
{
    private final AuthRequestHolder authRequestHolder;

    public CompanyRegistration(AuthRequestHolder authRequestHolder)
    {
        this.authRequestHolder = authRequestHolder;
    }

    @Given("^User provides correct registration information$")
    public void userProvidesCorrectRegistrationInformation()
    {
        authRequestHolder.set(new CompanyRegistrationRequest());
    }

    @Given("^User provides empty company name$")
    public void userProvidesEmptyCompanyName() throws Throwable
    {
        authRequestHolder.set(new CompanyRegistrationRequest().withCompanyName(""));
    }

    @Given("^User provides empty email$")
    public void userProvidesEmptyEmail() throws Throwable
    {
        authRequestHolder.set(new CompanyRegistrationRequest().withEmail(""));
    }

    @Given("^User provides existent email$")
    public void userProvidesExistentEmail() throws Throwable
    {
        new CompanyRegistrationRequest().withEmail("same@email.com").send();
        authRequestHolder.set(new CompanyRegistrationRequest().withEmail("same@email.com"));
    }

    @Given("^User provides invalid email$")
    public void userProvidesInvalidEmail() throws Throwable
    {
        authRequestHolder.set(new CompanyRegistrationRequest().withEmail("invalid@email@.com."));
    }
}
