package com.lealpoints.tests.functional.scenarios.login;

import com.lealpoints.tests.actions.login.company.UserLoginAction;
import com.lealpoints.tests.actions.registration.company.ActivateUserAction;
import com.lealpoints.tests.actions.registration.company.RegistrationAction;
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
    final RegistrationAction.Data _registrationData = RegistrationAction.DEFAULT_DATA
            .setEmail(_email)
            .setPassword(_password)
            .setPasswordConfirmation(_password);

    @Before
    public void setUp() {
        final ServiceResult serviceResult = RegistrationAction.registerCompany(_registrationData);
        ActivateUserAction.activate(serviceResult.getExtraInfo());
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = UserLoginAction.loginCompanyUser(_email, _password);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
        JSONObject jsonObject = new JSONObject(serviceResult.getObject());
        assertTrue(jsonObject.getBoolean("isActive"));
        assertFalse(jsonObject.getBoolean("mustChangePassword"));
    }
}