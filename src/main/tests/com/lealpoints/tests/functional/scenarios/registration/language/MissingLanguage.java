package com.lealpoints.tests.functional.scenarios.registration.language;

import com.lealpoints.tests.actions.registration.company.RegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertTrue;

public class MissingLanguage extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "We've sent you an email. Open it up to activate your account. " +
                "If you do not receive that email within 1 hour, please email support@lealpoints.com");
        _expectedMessages.put(Language.SPANISH, "Se ha enviado un link de activación a su correo. " +
                "Si no lo recibe dentro de una hora, favor de enviar un correo a support@lealpoints.com");
    }

    @Test
    public void test() {
        ServiceResult serviceResult =
                RegistrationAction.registerCompany(RegistrationAction.getDefaultData().setLanguage(""));
        assertTrue(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}

