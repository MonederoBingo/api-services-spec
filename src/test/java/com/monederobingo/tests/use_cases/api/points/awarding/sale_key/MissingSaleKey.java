package com.monederobingo.tests.use_cases.api.points.awarding.sale_key;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class MissingSaleKey extends ApiUseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
//        serviceResult = new PointsAwardingRequest(getApiUser())
//                .setSaleKey("")
//                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "You should specify a sale key");
        expectedMessages.put(Language.SPANISH, "Indique el número de venta.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

