package com.lealpoints.tests.functional.scenarios.registration.company.email;

import com.lealpoints.tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class ExistentEmail extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "This email is already being used on Leal Points.");
        _expectedMessages.put(Language.SPANISH, "Este correo ya se esta utilizando en Leal Points.");
    }

    @Before
    public void setUp() {
        CompanyRegistrationAction.registerCompany();
    }

    @Test
    public void test() {
        ServiceResult serviceResult = CompanyRegistrationAction.registerCompany();
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}

