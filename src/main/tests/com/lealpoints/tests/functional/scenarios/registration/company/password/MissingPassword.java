package com.lealpoints.tests.functional.scenarios.registration.company.password;

import com.lealpoints.tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MissingPassword extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "Password must have at least 6 characters.");
        _expectedMessages.put(Language.SPANISH, "La contraseña debe tener al menos seis caracteres.");
    }

    @Test
    public void test() {
        final CompanyRegistrationAction.RequestData requestRequestData = CompanyRegistrationAction.getRequestData().setPassword("");
        ServiceResult serviceResult = CompanyRegistrationAction.registerCompany(requestRequestData);
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}
