package com.monederobingo.tests.use_cases.api.promotions.apply.phone;

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
//        ApplyPromotionRequest applyPromotionRequest = new ApplyPromotionRequest(getApiUser());
//        applyPromotionRequest.withPhoneNumber("6661234567");
//        applyPromotionRequest.setPromotionConfigurationId(0);
//        serviceResult = applyPromotionRequest.send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
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

