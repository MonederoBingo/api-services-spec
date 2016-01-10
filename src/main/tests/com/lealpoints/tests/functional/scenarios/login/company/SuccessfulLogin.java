package com.lealpoints.tests.functional.scenarios.login.company;

import com.lealpoints.tests.actions.login.CompanyUserLoginAction;
import com.lealpoints.tests.actions.registration.ActivateCompanyUserAction;
import com.lealpoints.tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulLogin extends BaseApiTest {
    private final String _email = "test@lealpoints.com";
    private final String _password = "Password";
    private final CompanyRegistrationAction.RequestData _requestRequestData = CompanyRegistrationAction.getRequestData()
            .setEmail(_email)
            .setPassword(_password)
            .setPasswordConfirmation(_password);

    @Before
    public void setUp() {
        final ServiceResult serviceResult = CompanyRegistrationAction.registerCompany(_requestRequestData);
        ActivateCompanyUserAction.activate(serviceResult.getExtraInfo());
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = CompanyUserLoginAction.loginUser(_email, _password);
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