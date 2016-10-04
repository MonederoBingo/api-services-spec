package com.monederobingo.tests.use_cases.api.points.awarding.sale_key;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExistentSaleKey extends ApiUseCase
{
    private ServiceResult serviceResult;

    @Before
    public void setUp() {
//        new PointsAwardingRequest(getApiUser()).send();
    }

    @Test
    public void test() {
//        serviceResult = new PointsAwardingRequest(getApiUser()).send();
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

