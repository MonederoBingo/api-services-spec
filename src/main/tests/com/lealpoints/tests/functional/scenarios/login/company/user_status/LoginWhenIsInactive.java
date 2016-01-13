package com.lealpoints.tests.functional.scenarios.login.company.user_status;

import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class LoginWhenIsInactive extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "You user is not active, please verify your email and click on the " +
                "activation link.");
        expectedMessages.put(Language.SPANISH, "Su usuario no esta activo, favor de verificar su correo y dar " +
                "clic en el link de activación.");
    }

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
        assertFalse(jsonObject.getBoolean("isActive"));
        assertFalse(jsonObject.getBoolean("mustChangePassword"));
        assertServiceMessages(serviceResult, expectedMessages);
    }
}