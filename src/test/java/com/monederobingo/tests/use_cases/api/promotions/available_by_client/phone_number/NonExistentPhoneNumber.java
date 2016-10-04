package com.monederobingo.tests.use_cases.api.promotions.available_by_client.phone_number;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class NonExistentPhoneNumber extends ApiUseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
//        serviceResult = new PromotionGetAvailableByClientRequest(getApiUser()).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Phone number does not exist.");
        expectedMessages.put(Language.SPANISH, "El número de teléfono no existe.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

