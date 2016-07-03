package com.monederobingo.tests.use_cases.auth.login.company;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.requests.auth.login.CompanyUserLoginRequest;
import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulLogin extends UseCase
{
    private ServiceResult serviceResult;
    private final String email = "test@lealpoints.com";
    private final String password = "Password";

    @Before
    public void setUp() {
        final ServiceResult serviceResult = new CompanyRegistrationRequest()
                .setEmail(email)
                .setPassword(password)
                .setPasswordConfirmation(password)
                .send();
        new ActivateCompanyUserRequest().send(serviceResult.getExtraInfo());
    }

    @Test
    public void test() {
        serviceResult = new CompanyUserLoginRequest()
                .setEmail(email)
                .setPassword(password)
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        JSONObject jsonObject = serviceResult.getJSONObject();
        assertNotNull(jsonObject);
        assertTrue(jsonObject.getBoolean("isActive"));
        assertFalse(jsonObject.getBoolean("mustChangePassword"));
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
