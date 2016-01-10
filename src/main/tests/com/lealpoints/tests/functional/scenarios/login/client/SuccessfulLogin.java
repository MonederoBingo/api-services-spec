package com.lealpoints.tests.functional.scenarios.login.client;

import com.lealpoints.tests.actions.login.ClientUserLoginAction;
import com.lealpoints.tests.actions.registration.ClientRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuccessfulLogin extends BaseApiTest {
    private final String _phoneNumber = "9991234567";
    private String _smsKey;
    private final ClientRegistrationAction.RequestData _registrationRequestData = ClientRegistrationAction.getRequestData()
            .setPhoneNumber(_phoneNumber);

    @Before
    public void setUp() {
        final ServiceResult serviceResult = ClientRegistrationAction.registerClient(_registrationRequestData);
        _smsKey = serviceResult.getObject();
    }

    @Test
    public void test() {
        ClientUserLoginAction.RequestData requestData = new ClientUserLoginAction.RequestData()
                .setPhoneNumber(_phoneNumber)
                .setSmsKey(_smsKey);
        final ServiceResult serviceResult = ClientUserLoginAction.loginUser(requestData);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
        JSONObject jsonObject = serviceResult.getJSONObject();
        assertNotNull(jsonObject);
        assertTrue(jsonObject.getInt("clientUserId") > 0);
        assertTrue(jsonObject.has("apiKey"));
        assertNotEquals("", jsonObject.getString("apiKey"));
    }
}