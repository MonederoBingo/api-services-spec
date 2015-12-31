package com.lealpoints.tests.functional.scenarios.registration.email;

import com.lealpoints.tests.actions.registration.company.RegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class InvalidEmail extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "Specify a valid email");
        _expectedMessages.put(Language.SPANISH, "Indique un email válido");
    }

    @Test
    public void test() {
        ServiceResult serviceResult =
                RegistrationAction.registerCompany(RegistrationAction.DEFAULT_DATA.setEmail("invalid_email.."));
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}

