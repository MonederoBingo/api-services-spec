package com.monederobingo.tests.use_cases.auth.login.company.user_status;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.login.CompanyUserLoginRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class LoginWhenIsInactive extends UseCase
{
    private ServiceResult serviceResult;
    private final String email = "test@lealpoints.com";
    private final String password = "Password";

    @Before
    public void setUp() {
        new CompanyRegistrationRequest()
                .setEmail(email)
                .setPassword(password)
                .setPasswordConfirmation(password)
                .send();
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
        assertFalse(jsonObject.getBoolean("isActive"));
        assertFalse(jsonObject.getBoolean("mustChangePassword"));
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "You user is not active, please verify your email and click on the " +
                "activation link.");
        expectedMessages.put(Language.SPANISH, "Su usuario no esta activo, favor de verificar su correo y dar " +
                "clic en el link de activación.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}
