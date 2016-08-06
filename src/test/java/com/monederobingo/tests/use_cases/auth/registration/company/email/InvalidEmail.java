package com.monederobingo.tests.use_cases.auth.registration.company.email;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.tests.use_cases.UseCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class InvalidEmail extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest()
                .withEmail("invalid_email..")
                .send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Specify a valid email");
        expectedMessages.put(Language.SPANISH, "Indique un email válido");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

