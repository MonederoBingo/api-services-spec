package com.lealpoints.tests.functional.scenarios.activation;

import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
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

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "Your user has been activated.");
        expectedMessages.put(Language.SPANISH, "Su usuario se ha activado.");
    }

    @Test
    public void test() {
        final ServiceResult registrationServiceResult = new CompanyRegistrationRequest().send();
        final ServiceResult serviceResult = new ActivateCompanyUserRequest().send(registrationServiceResult.getExtraInfo());
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

