package com.lealpoints.automated_tests.functional.login;

import com.lealpoints.automated_tests.actions.login.CompanyUserLoginAction;
import com.lealpoints.automated_tests.functional.BaseApiTest;
import com.lealpoints.automated_tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.automated_tests.model.Language;
import com.lealpoints.automated_tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.automated_tests.functional.common.CommonTests.testMessages;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CompanyUserLoginTest extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "You user is not active, please verify your email and click on the " +
                "activation link.");
        expectedMessages.put(Language.SPANISH, "Su usuario no esta activo, favor de verificar su correo y dar " +
                "clic en el link de activación.");
    }

    @Test
    public void testRegisterCompany() {
        final String email = "test@lealpoints.com";
        final String password = "Password";
        CompanyRegistrationAction.registerCompany(getRegistrationData(email, password));
        final ServiceResult serviceResult = CompanyUserLoginAction.loginCompanyUser(email, password);
        runAssertions(serviceResult);
    }

    private CompanyRegistrationAction.Data getRegistrationData(String email, String password) {
        return new CompanyRegistrationAction.Data()
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

