package com.monederobingo.tests.use_cases.auth.login.client;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.login.ClientUserLoginRequest;
import com.monederobingo.api.client.requests.auth.registration.ClientRegistrationRequest;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class SuccessfulLogin extends UseCase
{
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
