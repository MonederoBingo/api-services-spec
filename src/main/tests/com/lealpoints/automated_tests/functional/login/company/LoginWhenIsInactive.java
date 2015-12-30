package com.lealpoints.automated_tests.functional.login.company;

import com.lealpoints.automated_tests.actions.login.company.UserLoginAction;
import com.lealpoints.automated_tests.functional.BaseApiTest;
import com.lealpoints.automated_tests.actions.registration.company.RegistrationAction;
import com.lealpoints.automated_tests.model.Language;
import com.lealpoints.automated_tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.automated_tests.functional.common.CommonTests.testMessages;
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
        RegistrationAction.registerCompany(getRegistrationData(email, password));
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = UserLoginAction.loginCompanyUser(email, password);
        runAssertions(serviceResult);
    }

    private RegistrationAction.Data getRegistrationData(String email, String password) {
        return new RegistrationAction.Data()
                .setEmail(email)
                .setPassword(password)
                .setPasswordConfirmation(password);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
        JSONObject jsonObject = new JSONObject(serviceResult.getObject());
        assertFalse(jsonObject.getBoolean("isActive"));
        assertFalse(jsonObject.getBoolean("mustChangePassword"));
        testMessages(serviceResult, expectedMessages);
    }
}