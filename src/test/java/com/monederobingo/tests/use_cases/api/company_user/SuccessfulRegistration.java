package com.monederobingo.tests.use_cases.api.company_user;

import com.monederobingo.tests.use_cases.api.ApiUseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.api.users.CompanyUserRegistrationRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulRegistration extends ApiUseCase
{
    private ServiceResult serviceResult;

    public void test() {
        serviceResult = new CompanyUserRegistrationRequest(getApiUser()).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(Long.parseLong(serviceResult.getObject()) > 0);
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "The user was successfully added.");
        expectedMessages.put(Language.SPANISH, "El usuario fue agregado exitosamente.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

