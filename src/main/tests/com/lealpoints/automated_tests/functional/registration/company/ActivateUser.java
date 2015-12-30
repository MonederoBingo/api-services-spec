package com.lealpoints.automated_tests.functional.registration.company;

import com.lealpoints.automated_tests.actions.registration.company.ActivateUserAction;
import com.lealpoints.automated_tests.actions.registration.company.RegistrationAction;
import com.lealpoints.automated_tests.functional.BaseApiTest;
import com.lealpoints.automated_tests.model.Language;
import com.lealpoints.automated_tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.automated_tests.functional.common.CommonTests.testMessages;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ActivateUser extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "Your user has been activated.");
        expectedMessages.put(Language.SPANISH, "Su usuario se ha activado.");
    }

    @Test
    public void test() {
        final ServiceResult registrationServiceResult = RegistrationAction.registerCompany(RegistrationAction.DEFAULT_DATA);
        final ServiceResult serviceResult = ActivateUserAction.activate(registrationServiceResult.getExtraInfo());
        testMessages(serviceResult, expectedMessages);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
    }
}

