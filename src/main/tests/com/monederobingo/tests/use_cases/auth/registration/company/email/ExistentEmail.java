package com.monederobingo.tests.use_cases.auth.registration.company.email;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class ExistentEmail extends UseCase
{

    private ServiceResult serviceResult;

    @Before
    public void setUp() {
        new CompanyRegistrationRequest().send();
    }

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest().send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "This email is already being used on Monedero Bingo.");
        expectedMessages.put(Language.SPANISH, "Este correo ya se esta utilizando en Monedero Bingo.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

