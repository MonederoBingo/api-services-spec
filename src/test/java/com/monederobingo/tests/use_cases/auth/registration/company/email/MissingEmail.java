package com.monederobingo.tests.use_cases.auth.registration.company.email;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class MissingEmail extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest()
                .setEmail("")
                .send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Please specify your email");
        expectedMessages.put(Language.SPANISH, "Ingresa tu correo electrónico");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

