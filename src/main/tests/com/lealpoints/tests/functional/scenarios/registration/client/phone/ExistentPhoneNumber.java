package com.lealpoints.tests.functional.scenarios.registration.client.phone;

import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ExistentPhoneNumber extends BaseApiTest {
    @Before
    public void setUp() {
        new ClientRegistrationRequest().send();
    }

    @Test
    public void invalidNumber() {
        ServiceResult serviceResult = new ClientRegistrationRequest().send();
        assertTrue(serviceResult.isSuccess());
    }
}

