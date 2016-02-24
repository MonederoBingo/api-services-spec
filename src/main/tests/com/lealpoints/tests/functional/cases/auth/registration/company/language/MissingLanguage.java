package com.lealpoints.tests.functional.cases.auth.registration.company.language;

import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MissingLanguage extends BaseTest {
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest()
                .setLanguage("")
                .send();
        assertTrue(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "We've sent you an email. Open it up to activate your account. " +
                "If you do not receive that email within 1 hour, please email support@monederobingo.com");
        expectedMessages.put(Language.SPANISH, "Se ha enviado un link de activación a su correo. " +
                "Si no lo recibe dentro de una hora, favor de enviar un correo a support@monederobingo.com");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

