package com.lealpoints.tests.functional.scenarios.points.awarding.sale_key;

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

public class MissingSaleKey extends BaseApiTest {
    private ApiUser apiUser;
    private static Map<Language, String> expectedMessages = new HashMap<>();
    static {
        expectedMessages.put(Language.ENGLISH, "You should specify a sale key");
        expectedMessages.put(Language.SPANISH, "Indique el número de venta.");
    }

    @Before
    public void setUp() {
        apiUser = loginCompanyAndGetApiUser();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new PointsAwardingRequest(apiUser)
                .setSaleKey("")
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

