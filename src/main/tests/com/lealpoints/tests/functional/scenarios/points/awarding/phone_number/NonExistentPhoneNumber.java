package com.lealpoints.tests.functional.scenarios.points.awarding.phone_number;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NonExistentPhoneNumber extends BaseApiTest {
    private ApiUser apiUser;
    private static Map<Language, String> expectedMessages = new HashMap<>();
    static {
        expectedMessages.put(Language.ENGLISH, "Points awarded: 100.0");
        expectedMessages.put(Language.SPANISH, "Puntos otorgados: 100.0");
    }

    @Before
    public void setUp() {
        apiUser = loginCompanyAndGetApiUser();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new PointsAwardingRequest(apiUser)
                .setPhoneNumber("1234567890")
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals("100.0", serviceResult.getObject());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

