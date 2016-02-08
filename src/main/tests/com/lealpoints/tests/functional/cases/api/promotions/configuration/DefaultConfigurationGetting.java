package com.lealpoints.tests.functional.cases.api.promotions.configuration;

import com.lealpoints.tests.functional.cases.api.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.promotions.PromotionConfigurationRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DefaultConfigurationGetting extends BaseApiTest {

    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new PromotionConfigurationRequest(getApiUser()).send();
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

