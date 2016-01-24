package com.lealpoints.tests.functional.cases.points.awarding.phone_number;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.points.PointsAwardingRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonSetup.loginCompanyAndGetApiUser;
import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertNotNull;

public class InvalidPhoneNumber extends BaseApiTest {
    private ApiUser apiUser;
    private static Map<Language, String> expectedMessages = new HashMap<>();
    static {
        expectedMessages.put(Language.ENGLISH, "Phone must have 10 digits.");
        expectedMessages.put(Language.SPANISH, "El número de teléfono debe tener al menos 10 dígitos.");
    }

    @Before
    public void setUp() {
        apiUser = loginCompanyAndGetApiUser();
    }

    @Test
    public void testInvalidNumber() {
        testPhoneNumber("INVALID_PHONE_NUMBER");
    }

    @Test
    public void testShortNumber() {
        testPhoneNumber("6612345");
    }

    private void testPhoneNumber(String phoneNumber) {
        final ServiceResult serviceResult = new PointsAwardingRequest(apiUser)
                .setPhoneNumber(phoneNumber)
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

