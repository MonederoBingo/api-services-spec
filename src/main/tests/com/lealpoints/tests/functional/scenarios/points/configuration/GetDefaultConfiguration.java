package com.lealpoints.tests.functional.scenarios.points.configuration;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.points.PointsConfigurationRequest;
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
        final ServiceResult serviceResult = new PointsConfigurationRequest(apiUser).send();
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

