package com.monederobingo.tests.use_cases.auth.login.company.credentials;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.login.CompanyUserLoginRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class WrongPassword extends UseCase
{
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
