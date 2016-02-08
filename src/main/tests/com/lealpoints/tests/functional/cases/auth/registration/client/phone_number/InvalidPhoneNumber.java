package com.lealpoints.tests.functional.cases.auth.registration.client.phone_number;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class InvalidPhoneNumber extends BaseTest {
    private ServiceResult serviceResult;

    @Test
    public void invalidNumber() {
        testPhoneNumber("INVALID_NUMBER");
    }

    @Test
    public void shortNumber() {
        testPhoneNumber("999123");
    }

    private void testPhoneNumber(String phoneNumber) {
        serviceResult = new ClientRegistrationRequest().setPhoneNumber(phoneNumber).send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Phone must have 10 digits.");
        expectedMessages.put(Language.SPANISH, "El número de teléfono debe tener al menos 10 dígitos.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

