package com.lealpoints.tests.functional.cases.auth.login.company.credentials;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class WrongPassword extends BaseTest {
    private ServiceResult serviceResult;
    private final String email = "test@lealpoints.com";

    @Before
    public void setUp() {
        final ServiceResult registrationServiceResult = new CompanyRegistrationRequest()
                .setEmail(email)
                .setPassword("Password")
                .setPasswordConfirmation("Password")
                .send();
        new ActivateCompanyUserRequest().send(registrationServiceResult.getExtraInfo());
    }

    @Test
    public void test() {
        CompanyUserLoginRequest companyUserLoginRequest = new CompanyUserLoginRequest()
                .setEmail(email)
                .setPassword("DIFFERENT_PASSWORD");
        serviceResult = companyUserLoginRequest.send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Login failed! Please verify your information.");
        expectedMessages.put(Language.SPANISH, "No se pudo iniciar sesión, verifique su correo y contraseña.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}