package com.monederobingo.tests.use_cases.auth.registration.company.password;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class MissingPassword extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest()
                .setPassword("")
                .send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Password must have at least 6 characters.");
        expectedMessages.put(Language.SPANISH, "La contraseña debe tener al menos seis caracteres.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

