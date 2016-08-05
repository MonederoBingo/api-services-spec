/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompanyRegistration
{
    private CompanyRegistrationRequest companyRegistrationRequest;
    private ServiceResult serviceResult;

    @Given("^User provides correct registration information$")
    public void userProvidesCorrectRegistrationInformation()
    {
        companyRegistrationRequest = new CompanyRegistrationRequest();
    }

    @When("^User sends registration request$")
    public void userSendRegistrationRequest() throws Throwable
    {
        serviceResult = companyRegistrationRequest.send();
    }

    @Then("^The response should be successful$")
    public void theResponseShouldBeSuccessful() throws Throwable
    {
        assertTrue(serviceResult.isSuccess());
    }

    @And("^The user should receive a message the following messages$")
    public void theUserShouldReceiveAMessageTheFollowingMessages(Map<Language, String> expectedMessages) throws Throwable
    {
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResult.getMessage());
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResult.getTranslation(Language.ENGLISH));
        assertEquals(expectedMessages.get(Language.SPANISH), serviceResult.getTranslation(Language.SPANISH));
    }
}
