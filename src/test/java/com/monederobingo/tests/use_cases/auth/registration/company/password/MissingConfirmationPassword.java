package com.monederobingo.tests.use_cases.auth.registration.company.password;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.tests.use_cases.UseCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class MissingConfirmationPassword extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest()
                .setPasswordConfirmation("")
                .send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
       Map<Language, String> expectedMessages = new HashMap<>();
            expectedMessages.put(Language.ENGLISH, "Password and confirmation are different.");
            expectedMessages.put(Language.SPANISH, "La contraseña y la confirmación son diferentes.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

