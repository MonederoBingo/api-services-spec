package com.lealpoints.automated_tests.functional.registration;

import com.lealpoints.automated_tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.automated_tests.functional.BaseApiTest;
import com.lealpoints.automated_tests.model.Language;
import com.lealpoints.automated_tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.automated_tests.actions.util.TestUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.lealpoints.automated_tests.functional.common.CommonTests.testMessages;

public class CompanyRegistrationTest extends BaseApiTest {

    private static Map<Language, String> expectedMessages = new HashMap<>();
    static {
        expectedMessages.put(Language.ENGLISH, "We've sent you an email. Open it up to activate your account. " +
                "If you do not receive that email within 1 hour, please email support@lealpoints.com");
        expectedMessages.put(Language.SPANISH, "Se ha enviado un link de activación a su correo. Si no lo recibe " +
                "dentro de una hora, favor de enviar un correo a support@lealpoints.com");
    }

    @Test
    public void testRegisterCompany() {
        final String json = buildRequestBody();
        ServiceResult serviceResult = CompanyRegistrationAction.registerCompany(json);
        assertEquals(true, serviceResult.isSuccess());
        testMessages(serviceResult, expectedMessages);
        assertTrue(isInteger(serviceResult.getObject()));
    }

    private String buildRequestBody() {
        return new JSONObject() //
                .put("companyName", "company name") //
                .put("urlImageLogo", "images/logo.png") //
                .put("userName", "user name") //
                .put("email", "test4@email.com") //
                .put("password", "Pa$$w0rd") //
                .put("passwordConfirmation", "Pa$$w0rd") //
                .put("language", "") //
                .toString();
    }
}

