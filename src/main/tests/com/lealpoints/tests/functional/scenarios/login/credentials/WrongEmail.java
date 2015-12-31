package com.lealpoints.tests.functional.scenarios.login.credentials;

import com.lealpoints.tests.actions.login.company.UserLoginAction;
import com.lealpoints.tests.actions.registration.company.ActivateUserAction;
import com.lealpoints.tests.actions.registration.company.RegistrationAction;
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

    private final String _password = "Password";
    private final RegistrationAction.Data _registrationData = RegistrationAction.DEFAULT_DATA
            .setEmail("test@lealpoints.com")
            .setPassword(_password)
            .setPasswordConfirmation(_password);

    @Before
    public void setUp() {
        final ServiceResult registrationServiceResult = RegistrationAction.registerCompany(_registrationData);
        ActivateUserAction.activate(registrationServiceResult.getExtraInfo());
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = UserLoginAction.loginCompanyUser("DIFFERENT_EMAIL@DIFFERENT.COM", _password);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}