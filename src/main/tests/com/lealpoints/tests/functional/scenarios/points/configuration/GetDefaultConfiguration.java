package com.lealpoints.tests.functional.scenarios.points.configuration;

import com.lealpoints.tests.actions.base.ApiAction;
import com.lealpoints.tests.actions.points.PointsConfigurationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.functional.util.CommonSetup;
import com.lealpoints.tests.model.ApiUser;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static com.lealpoints.tests.functional.util.CommonTests.isInteger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GetDefaultConfiguration extends BaseApiTest {

    private ApiUser _apiUser;
    @Before
    public void setUp() {
        _apiUser = CommonSetup.loginCompanyAndGetApiKey();
    }

    @Test
    public void test() {
        ApiAction apiAction = new PointsConfigurationAction(_apiUser);
        final ServiceResult serviceResult = apiAction.execute();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        JSONObject jsonObject = serviceResult.getJSONObject();
        assertNotNull(jsonObject);
        assertEquals(1, jsonObject.getInt("requiredAmount"));
        assertEquals(1, jsonObject.getInt("pointsToEarn"));
        assertTrue(jsonObject.has("pointsConfigurationId"));
        assertTrue(jsonObject.has("companyId"));
    }
}

