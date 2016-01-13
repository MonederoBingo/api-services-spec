package com.lealpoints.tests.functional.scenarios.login.company.credentials;

import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.*;

public class WrongEmail extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "Login failed! Please verify your information.");
        expectedMessages.put(Language.SPANISH, "No se pudo iniciar sesión, verifique su correo y contraseña.");
    }

    private final String password = "Password";

    @Before
    public void setUp() {
        final ServiceResult registrationServiceResult = new CompanyRegistrationRequest()
                .setEmail("test@lealpoints.com")
                .setPassword(password)
                .setPasswordConfirmation(password)
                .send();
        new ActivateCompanyUserRequest().send(registrationServiceResult.getExtraInfo());
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new CompanyUserLoginRequest()
                .setEmail("DIFFERENT_EMAIL@DIFFERENT.COM")
                .setPassword(password)
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}