package com.lealpoints.tests.functional.cases.auth.activation;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulActivation extends BaseTest {

    private ServiceResult serviceResult;

    @Test
    public void test() {
        final ServiceResult registrationServiceResult = new CompanyRegistrationRequest().send();
        serviceResult = new ActivateCompanyUserRequest().send(registrationServiceResult.getExtraInfo());
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Your user has been activated.");
        expectedMessages.put(Language.SPANISH, "Su usuario se ha activado.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

