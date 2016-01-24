package com.lealpoints.tests.functional.cases.registration.company_user;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.users.CompanyUserRegistrationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonSetup.loginCompanyAndGetApiUser;
import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulRegistration extends BaseApiTest {
    private ApiUser apiUser;

    private static Map<Language, String> expectedMessages = new HashMap<>();

    static {
        expectedMessages.put(Language.ENGLISH, "The user was successfully added.");
        expectedMessages.put(Language.SPANISH, "El usuario fue agregado exitosamente.");
    }

    @Before
    public void setUp() {
        apiUser = loginCompanyAndGetApiUser();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new CompanyUserRegistrationRequest(apiUser).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(Long.parseLong(serviceResult.getObject()) > 0);
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

