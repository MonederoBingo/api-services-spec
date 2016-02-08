package com.lealpoints.tests.functional.cases.auth.registration.client;

import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.isInteger;
import static org.junit.Assert.assertTrue;

public class SuccessfulRegistration extends BaseTest {
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new ClientRegistrationRequest().send();
        assertTrue(serviceResult.isSuccess());
        assertTrue(isInteger(serviceResult.getObject()));
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        return null;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

