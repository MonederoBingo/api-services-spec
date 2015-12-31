package com.lealpoints.tests.functional.scenarios.activation;

import com.lealpoints.tests.actions.registration.company.ActivateUserAction;
import com.lealpoints.tests.actions.registration.company.RegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulActivation extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "Your user has been activated.");
        _expectedMessages.put(Language.SPANISH, "Su usuario se ha activado.");
    }

    @Test
    public void test() {
        final ServiceResult registrationServiceResult = RegistrationAction.registerCompany(RegistrationAction.DEFAULT_DATA);
        final ServiceResult serviceResult = ActivateUserAction.activate(registrationServiceResult.getExtraInfo());
        assertServiceMessages(serviceResult, _expectedMessages);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
    }
}

