package com.monederobingo.tests.use_cases.api.points.awarding.phone_number;

import com.monederobingo.tests.use_cases.api.ApiUseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.api.points.PointsAwardingRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class InvalidPhoneNumber extends ApiUseCase
{
    private ServiceResult serviceResult;

    @Test
    public void testInvalidNumber() {
        testPhoneNumber("INVALID_PHONE_NUMBER");
    }

    @Test
    public void testShortNumber() {
        testPhoneNumber("6612345");
    }

    private void testPhoneNumber(String phoneNumber) {
        serviceResult = new PointsAwardingRequest(getApiUser())
                .setPhoneNumber(phoneNumber)
                .send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Phone must have 10 digits.");
        expectedMessages.put(Language.SPANISH, "El número de teléfono debe tener al menos 10 dígitos.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

