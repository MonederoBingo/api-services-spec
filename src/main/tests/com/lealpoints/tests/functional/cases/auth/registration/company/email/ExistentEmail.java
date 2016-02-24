package com.lealpoints.tests.functional.cases.auth.registration.company.email;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class ExistentEmail extends BaseTest {

    private ServiceResult serviceResult;

    @Before
    public void setUp() {
        new CompanyRegistrationRequest().send();
    }

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest().send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "This email is already being used on Monedero Bingo.");
        expectedMessages.put(Language.SPANISH, "Este correo ya se esta utilizando en Monedero Bingo.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

