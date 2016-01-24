package com.lealpoints.tests.functional.cases.registration.client.phone_number;

import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class InvalidPhoneNumber extends BaseApiTest {
    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "Phone must have 10 digits.");
        expectedMessages.put(Language.SPANISH, "El número de teléfono debe tener al menos 10 dígitos.");
    }

    @Test
    public void invalidNumber() {
        testPhoneNumber("INVALID_NUMBER");
    }

    @Test
    public void shortNumber() {
        testPhoneNumber("999123");
    }

    private void testPhoneNumber(String phoneNumber) {
        ServiceResult serviceResult = new ClientRegistrationRequest().setPhoneNumber(phoneNumber).send();
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

