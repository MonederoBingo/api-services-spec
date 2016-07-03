package com.monederobingo.tests.use_cases.auth.activation.activation_key;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class WrongActivationKey extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        new CompanyRegistrationRequest().send();
        serviceResult = new ActivateCompanyUserRequest().send("DIFFERENT_ACTIVATION_KEY");
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, ":/ We are very sorry, there was an error. We're trying to solve it. " +
                "You can email us to support@monederobingo.com if you want to be updated about this.");
        expectedMessages.put(Language.SPANISH, ":/ Los sentimos, hubo un error. Estamos tratando de resolverlo, " +
                "puede enviarnos un correo a support@monederobingo.com si desea saber mas al respecto.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

