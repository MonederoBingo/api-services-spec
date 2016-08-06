/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.domain_verifiers;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.Map;

import static com.monederobingo.api.client.model.Language.ENGLISH;
import static com.monederobingo.api.client.model.Language.SPANISH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceResultVerifier
{
    private final ServiceResultHolder serviceResultHolder;

    public ServiceResultVerifier(ServiceResultHolder serviceResultHolder)
    {
        this.serviceResultHolder = serviceResultHolder;
    }

    @Then("^The response should be successful$")
    public void theResponseShouldBeSuccessful() throws Throwable
    {
        assertTrue(serviceResultHolder.get().isSuccess());
    }

    @Then("^The response should be not successful$")
    public void theResponseShouldBeNotSuccessful() throws Throwable
    {
        assertFalse(serviceResultHolder.get().isSuccess());
    }

    @And("^The user should receive the following messages$")
    public void theUserShouldReceiveTheFollowingMessages(Map<Language, String> expectedMessages) throws Throwable
    {
        assertEquals(expectedMessages.get(ENGLISH), serviceResultHolder.get().getMessage());
        assertEquals(expectedMessages.get(ENGLISH), serviceResultHolder.get().getTranslation(ENGLISH));
        assertEquals(expectedMessages.get(SPANISH), serviceResultHolder.get().getTranslation(SPANISH));
    }
}
