package com.lealpoints.tests.functional.scenarios.registration.company.email;

import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class MissingEmail extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "Please specify your email");
        expectedMessages.put(Language.SPANISH, "Ingresa tu correo electrónico");
    }

    @Test
    public void test() {
        ServiceResult serviceResult = new CompanyRegistrationRequest()
                .setEmail("")
                .send();
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

