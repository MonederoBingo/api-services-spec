package com.lealpoints.tests.functional.cases.auth.login.client.phone_number;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.login.ClientUserLoginRequest;
import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class InvalidPhoneNumber extends BaseTest {
    private ServiceResult serviceResult;
    private String _smsKey;

    @Before
    public void setUp() {
        final ClientRegistrationRequest clientRegistrationRequest = new ClientRegistrationRequest();
        clientRegistrationRequest.setPhoneNumber("9991234567");
        serviceResult = clientRegistrationRequest.send();
        _smsKey = serviceResult.getObject();
    }

    @Test
    public void invalidNumber() {
        testPhoneNumber("INVALID_PHONE_NUMBER");
    }

    @Test
    public void nonExistentNumber() {
        testPhoneNumber("9997654321");
    }

    private void testPhoneNumber(String phoneNumber) {
        serviceResult = new ClientUserLoginRequest()
                .setPhoneNumber(phoneNumber)
                .setSmsKey(_smsKey)
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Login failed! Please verify your information.");
        expectedMessages.put(Language.SPANISH, "No se pudo iniciar sesión, verifique su correo y contraseña.");
        return expectedMessages;

    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}