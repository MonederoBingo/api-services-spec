package com.lealpoints.tests.functional.cases.registration.company.password;

import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class MissingConfirmationPassword extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "Password and confirmation are different.");
        expectedMessages.put(Language.SPANISH, "La contraseña y la confirmación son diferentes.");
    }

    @Test
    public void test() {
        ServiceResult serviceResult = new CompanyRegistrationRequest()
                .setPasswordConfirmation("")
                .send();
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

