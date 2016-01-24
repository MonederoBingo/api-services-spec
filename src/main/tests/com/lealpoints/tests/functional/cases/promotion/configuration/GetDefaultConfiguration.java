package com.lealpoints.tests.functional.cases.promotion.configuration;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.promotions.PromotionConfigurationRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static com.lealpoints.tests.functional.util.CommonSetup.loginCompanyAndGetApiUser;
import static org.junit.Assert.*;

public class GetDefaultConfiguration extends BaseApiTest {
    private ApiUser apiUser;

    @Before
    public void setUp() {
        apiUser = loginCompanyAndGetApiUser();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new PromotionConfigurationRequest(apiUser).send();
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
}

