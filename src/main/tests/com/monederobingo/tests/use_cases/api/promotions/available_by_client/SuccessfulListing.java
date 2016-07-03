package com.monederobingo.tests.use_cases.api.promotions.available_by_client;

import com.monederobingo.tests.use_cases.api.ApiUseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.api.points.PointsAwardingRequest;
import com.monederobingo.api.client.requests.api.promotions.PromotionGetAvailableByClientRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SuccessfulListing extends ApiUseCase
{
    private ServiceResult serviceResult;
    String phoneNumber = "6661234567";

    @Before
    public void setUp(){
        PointsAwardingRequest pointsAwardingRequest = new PointsAwardingRequest(getApiUser());
        pointsAwardingRequest.setPhoneNumber(phoneNumber);
        pointsAwardingRequest.setSaleAmount(1000);
        pointsAwardingRequest.send();
    }

    @Test
    public void test() {
        PromotionGetAvailableByClientRequest promotionGetAvailableByClientRequest =
                new PromotionGetAvailableByClientRequest(getApiUser());
        promotionGetAvailableByClientRequest.setPhoneNumber(phoneNumber);
        serviceResult = promotionGetAvailableByClientRequest.send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertTrue(serviceResult.isSuccess());
        assertNotNull(serviceResult.getJSONArray());
        JSONArray jsonArray = serviceResult.getJSONArray();
        assertEquals(1, jsonArray.length());
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        assertTrue(jsonObject.getLong("companyId") > 0);
        assertTrue(jsonObject.getLong("promotionConfigurationId") > 0);
        assertEquals(1000, jsonObject.getDouble("requiredPoints"), 0.00);
        assertEquals("10% off in your next purchase!", jsonObject.getString("description"));
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        return null;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

