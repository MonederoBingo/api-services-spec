package com.monederobingo.tests.use_cases.auth.registration.company;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.tests.util.CommonTests;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SuccessfulRegistration extends UseCase
{
    private ServiceResult serviceResult;

    public void sendRegistrationRequest()
    {
        serviceResult = new CompanyRegistrationRequest().send();
    }

    public void asserts() {

        assertTrue(serviceResult.isSuccess());
        assertTrue(CommonTests.isInteger(serviceResult.getObject()));
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "We've sent you an email. Open it up to activate your account. " +
                "If you do not receive that email within 1 hour, please email support@monederobingo.com");
        expectedMessages.put(Language.SPANISH, "Se ha enviado un link de activación a su correo. Si no lo recibe " +
                "dentro de una hora, favor de enviar un correo a support@monederobingo.com");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

