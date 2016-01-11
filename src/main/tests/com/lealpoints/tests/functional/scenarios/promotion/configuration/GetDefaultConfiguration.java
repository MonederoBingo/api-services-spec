package com.lealpoints.tests.functional.scenarios.promotion.configuration;

import com.lealpoints.tests.actions.base.ApiAction;
import com.lealpoints.tests.actions.points.PointsConfigurationAction;
import com.lealpoints.tests.actions.promotions.PromotionConfigurationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.functional.util.CommonSetup;
import com.lealpoints.tests.model.ApiUser;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetDefaultConfiguration extends BaseApiTest {

    private ApiUser _apiUser;
    @Before
    public void setUp() {
        _apiUser = CommonSetup.loginCompanyAndGetApiKey();
    }

    @Test
    public void test() {
        ApiAction apiAction = new PromotionConfigurationAction(_apiUser);
        final ServiceResult serviceResult = apiAction.execute();
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

