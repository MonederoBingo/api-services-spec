package com.lealpoints.tests.functional.cases.auth.registration.client.phone_number;

import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ExistentPhoneNumber extends BaseTest {
    private ServiceResult serviceResult;

    @Before
    public void setUp() {
        new ClientRegistrationRequest().send();
    }

    @Test
    public void invalidNumber() {
        serviceResult = new ClientRegistrationRequest().send();
        assertTrue(serviceResult.isSuccess());
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

