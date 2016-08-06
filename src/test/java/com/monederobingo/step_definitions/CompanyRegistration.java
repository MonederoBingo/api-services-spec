/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CompanyRegistration
{
    private CompanyRegistrationRequest companyRegistrationRequest;
    private ServiceResultHolder serviceResultHolder;

    public CompanyRegistration(ServiceResultHolder serviceResultHolder)
    {
        this.serviceResultHolder = serviceResultHolder;
    }

    @Given("^User provides correct registration information$")
    public void userProvidesCorrectRegistrationInformation()
    {
        companyRegistrationRequest = new CompanyRegistrationRequest();
    }

    @When("^User sends registration request$")
    public void userSendRegistrationRequest() throws Throwable
    {
        serviceResultHolder.set(companyRegistrationRequest.send());
    }

    @And("^The user should receive a message the following messages$")
    public void theUserShouldReceiveAMessageTheFollowingMessages(Map<Language, String> expectedMessages) throws Throwable
    {
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResultHolder.get().getMessage());
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResultHolder.get().getTranslation(Language.ENGLISH));
        assertEquals(expectedMessages.get(Language.SPANISH), serviceResultHolder.get().getTranslation(Language.SPANISH));
    }

    @Given("^User provides empty company name$")
    public void userProvidesIncorrectCompanyName() throws Throwable
    {
        companyRegistrationRequest = new CompanyRegistrationRequest().withCompanyName("");
    }
}
