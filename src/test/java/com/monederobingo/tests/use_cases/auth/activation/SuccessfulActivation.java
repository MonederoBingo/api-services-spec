package com.monederobingo.tests.use_cases.auth.activation;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulActivation extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        final ServiceResult registrationServiceResult = new CompanyRegistrationRequest().send();
        serviceResult = new ActivateCompanyUserRequest().send(registrationServiceResult.getExtraInfo());
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Your user has been activated.");
        expectedMessages.put(Language.SPANISH, "Su usuario se ha activado.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

