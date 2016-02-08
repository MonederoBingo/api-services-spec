package com.lealpoints.tests.functional.cases.api.points.awarding.sale_key;

import com.lealpoints.tests.functional.cases.api.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.points.PointsAwardingRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExistentSaleKey extends BaseApiTest {
    private ServiceResult serviceResult;

    @Before
    public void setUp() {
        new PointsAwardingRequest(getApiUser()).send();
    }

    @Test
    public void test() {
        serviceResult = new PointsAwardingRequest(getApiUser()).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals("", serviceResult.getObject());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Sale key already exists.");
        expectedMessages.put(Language.SPANISH, "El número de venta ya existe.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

