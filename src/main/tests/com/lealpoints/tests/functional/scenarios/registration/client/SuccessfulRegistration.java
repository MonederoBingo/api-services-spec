package com.lealpoints.tests.functional.scenarios.registration.client;

import com.lealpoints.tests.actions.registration.ClientRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import static com.lealpoints.tests.functional.util.CommonTests.isInteger;
import static org.junit.Assert.assertTrue;

public class SuccessfulRegistration extends BaseApiTest {

    @Test
    public void test() {
        ServiceResult serviceResult = ClientRegistrationAction.registerClient();
        assertTrue(serviceResult.isSuccess());
        assertTrue(isInteger(serviceResult.getObject()));
    }
}

