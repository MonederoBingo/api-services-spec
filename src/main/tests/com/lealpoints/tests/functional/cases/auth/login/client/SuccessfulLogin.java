package com.lealpoints.tests.functional.cases.auth.login.client;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.login.ClientUserLoginRequest;
import com.lealpoints.tests.requests.auth.registration.ClientRegistrationRequest;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class SuccessfulLogin extends BaseTest {
    private final String _phoneNumber = "9991234567";
    private String _smsKey;
    private ServiceResult serviceResult;

    @Before
    public void setUp() {
        final ClientRegistrationRequest clientRegistrationRequest = new ClientRegistrationRequest();
        clientRegistrationRequest.setPhoneNumber(_phoneNumber);
        serviceResult = clientRegistrationRequest.send();
        _smsKey = serviceResult.getObject();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new ClientUserLoginRequest()
                .setPhoneNumber(_phoneNumber)
                .setSmsKey(_smsKey)
                .send();
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

    @Override
    protected Map<Language, String> getExpectedMessages() {
        return null;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}