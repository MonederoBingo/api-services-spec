/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import cucumber.api.java.en.Given;

public class CompanyRegistration
{
    private final CompanyRegistrationRequest companyRegistrationRequest;

    public CompanyRegistration(CompanyRegistrationRequest companyRegistrationRequest)
    {
        this.companyRegistrationRequest = companyRegistrationRequest;
    }

    @Given("^User provides correct registration information$")
    public void userProvidesCorrectRegistrationInformation()
    {

    }

    @Given("^User provides empty company name$")
    public void userProvidesEmptyCompanyName() throws Throwable
    {
        companyRegistrationRequest.withCompanyName("");
    }

    @Given("^User provides empty email$")
    public void userProvidesEmptyEmail() throws Throwable
    {
        companyRegistrationRequest.withEmail("");
    }

    @Given("^User provides existent email$")
    public void userProvidesExistentEmail() throws Throwable
    {
        new CompanyRegistrationRequest().withEmail("same@email.com").send();
        companyRegistrationRequest.withEmail("same@email.com");
    }

    @Given("^User provides invalid email$")
    public void userProvidesInvalidEmail() throws Throwable
    {
        companyRegistrationRequest.withEmail("invalid@email@.com.");
    }

    @Given("^User provides empty language$")
    public void userProvidesEmptyLanguage() throws Throwable
    {
        companyRegistrationRequest.withLanguage("");
    }
}
