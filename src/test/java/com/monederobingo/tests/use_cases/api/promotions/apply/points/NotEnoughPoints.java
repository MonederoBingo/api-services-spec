package com.monederobingo.tests.use_cases.api.promotions.apply.points;

import com.monederobingo.tests.use_cases.api.ApiUseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.api.points.PointsAwardingRequest;
import com.monederobingo.api.client.requests.api.promotions.ApplyPromotionRequest;
import com.monederobingo.api.client.requests.api.promotions.PromotionConfigurationRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NotEnoughPoints extends ApiUseCase
{
    private final String phoneNumber = "6661234567";
    private ServiceResult serviceResult;
    long promotionConfigurationId;

    @Before
    public void setUp() {
        PointsAwardingRequest pointsAwardingRequest = new PointsAwardingRequest(getApiUser());
        pointsAwardingRequest.setPhoneNumber(phoneNumber);
        pointsAwardingRequest.setSaleAmount(10);
        pointsAwardingRequest.send();

        ServiceResult serviceResult = new PromotionConfigurationRequest(getApiUser()).send();
        promotionConfigurationId = serviceResult.getJSONArray().getJSONObject(0).getLong("promotionConfigurationId");
    }

    @Test
    public void test() {
        ApplyPromotionRequest applyPromotionRequest = new ApplyPromotionRequest(getApiUser());
        applyPromotionRequest.setPhoneNumber(phoneNumber);
        applyPromotionRequest.setPromotionConfigurationId(promotionConfigurationId);
        serviceResult = applyPromotionRequest.send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "The client does not have enought points.");
        expectedMessages.put(Language.SPANISH, "El cliente no tiene suficientes puntos.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}
