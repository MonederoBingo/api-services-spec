package com.lealpoints.tests.functional.scenarios.registration.password;

import com.lealpoints.tests.actions.registration.company.RegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class PasswordAndConfirmationAreDifferent extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();
    private final RegistrationAction.Data _requestData = RegistrationAction.getRequestData()
            .setPassword("password")
            .setPasswordConfirmation("different_password");

    static {
        _expectedMessages.put(Language.ENGLISH, "Password and confirmation are different.");
        _expectedMessages.put(Language.SPANISH, "La contraseña y la confirmación son diferentes.");
    }

    @Test
    public void test() {
        final RegistrationAction.Data requestData = _requestData;
        ServiceResult serviceResult = RegistrationAction.registerCompany(requestData);
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}

