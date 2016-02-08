package com.lealpoints.tests.functional.cases.api.points.configuration;

import com.lealpoints.tests.functional.cases.api.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.points.PointsConfigurationRequest;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DefaultConfigurationGetting extends BaseApiTest {

    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new PointsConfigurationRequest(getApiUser()).send();
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

    @Override
    protected Map<Language, String> getExpectedMessages() {
        return null;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

