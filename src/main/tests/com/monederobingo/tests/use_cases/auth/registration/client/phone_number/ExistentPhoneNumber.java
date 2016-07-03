package com.monederobingo.tests.use_cases.auth.registration.client.phone_number;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import com.monederobingo.tests.use_cases.UseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ExistentPhoneNumber extends UseCase
{
    private ServiceResult serviceResult;

    @Before
    public void setUp() {
        new ClientRegistrationRequest().send();
    }

    @Test
    public void invalidNumber() {
        serviceResult = new ClientRegistrationRequest().send();
        assertTrue(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        return null;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

