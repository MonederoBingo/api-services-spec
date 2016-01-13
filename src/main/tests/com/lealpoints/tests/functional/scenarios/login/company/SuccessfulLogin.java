package com.lealpoints.tests.functional.scenarios.login.company;

import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulLogin extends BaseApiTest {
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
        final ServiceResult serviceResult = new CompanyUserLoginRequest()
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
}