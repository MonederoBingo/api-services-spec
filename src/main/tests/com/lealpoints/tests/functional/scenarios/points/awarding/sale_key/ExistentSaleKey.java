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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExistentSaleKey extends BaseApiTest {
    private ApiUser apiUser;
    private static Map<Language, String> expectedMessages = new HashMap<>();
    static {
        expectedMessages.put(Language.ENGLISH, "Sale key already exists.");
        expectedMessages.put(Language.SPANISH, "El número de venta ya existe.");
    }

    @Before
    public void setUp() {
        apiUser = loginCompanyAndGetApiUser();
        new PointsAwardingRequest(apiUser).send();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new PointsAwardingRequest(apiUser).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals("100.0", serviceResult.getObject());
        assertServiceMessages(serviceResult, expectedMessages);
    }
}

