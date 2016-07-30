package com.monederobingo.tests.use_cases.auth.registration.client;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.tests.util.CommonTests;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SuccessfulRegistration extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new ClientRegistrationRequest().send();
        assertTrue(serviceResult.isSuccess());
        assertTrue(CommonTests.isInteger(serviceResult.getObject()));
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

