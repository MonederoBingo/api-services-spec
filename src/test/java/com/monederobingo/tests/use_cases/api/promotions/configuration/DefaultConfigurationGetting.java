package com.monederobingo.tests.use_cases.api.promotions.configuration;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DefaultConfigurationGetting extends ApiUseCase
{

    private ServiceResult serviceResult;

    @Test
    public void test() {
        //  serviceResult = new PromotionConfigurationRequest(getApiUser()).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        JSONArray jsonArray = serviceResult.getJSONArray();
        assertNotNull(jsonArray);
        assertEquals(1, jsonArray.length());
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        assertTrue(jsonObject.has("companyId"));
        assertTrue(jsonObject.has("promotionConfigurationId"));
        assertEquals(1000, jsonObject.getInt("requiredPoints"));
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

