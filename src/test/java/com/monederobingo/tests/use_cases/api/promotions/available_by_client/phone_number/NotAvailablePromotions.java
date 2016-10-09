package com.monederobingo.tests.use_cases.api.promotions.available_by_client.phone_number;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class NotAvailablePromotions extends ApiUseCase
{
    String phoneNumber = "6661234567";
    private ServiceResult serviceResult;

    @Before
    public void setUp(){
//        PointsAwardingRequest pointsAwardingRequest = new PointsAwardingRequest(getApiUser());
//        pointsAwardingRequest.withPhoneNumber(phoneNumber);
//        pointsAwardingRequest.send();
    }

    @Test
    public void test() {
//        PromotionGetAvailableByClientRequest promotionGetAvailableByClientRequest =
//                new PromotionGetAvailableByClientRequest(getApiUser());
//        promotionGetAvailableByClientRequest.withPhoneNumber(phoneNumber);
//        serviceResult = promotionGetAvailableByClientRequest.send();
//        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Client does not have available promotions.");
        expectedMessages.put(Language.SPANISH, "El cliente no alcanza ninguna promoción.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

