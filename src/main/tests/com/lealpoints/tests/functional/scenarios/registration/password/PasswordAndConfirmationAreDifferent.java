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

    static {
        _expectedMessages.put(Language.ENGLISH, "Password and confirmation are different.");
        _expectedMessages.put(Language.SPANISH, "La contraseña y la confirmación son diferentes.");
    }

    @Test
    public void test() {
        ServiceResult serviceResult = RegistrationAction.registerCompany(getData());
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }

    private RegistrationAction.Data getData() {
        return RegistrationAction.getDefaultData()
                .setPassword("password")
                .setPasswordConfirmation("different_password");
    }
}

