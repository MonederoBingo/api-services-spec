package com.monederobingo.tests.use_cases.api.points.awarding.phone_number;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NonExistentPhoneNumber extends ApiUseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
//        serviceResult = new PointsAwardingRequest(getApiUser())
//                .withPhoneNumber("1234567890")
//                .send();
//        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals("100.0", serviceResult.getObject());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Points awarded: 100.0");
        expectedMessages.put(Language.SPANISH, "Puntos otorgados: 100.0");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

