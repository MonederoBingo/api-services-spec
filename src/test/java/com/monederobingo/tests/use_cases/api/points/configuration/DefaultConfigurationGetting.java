package com.monederobingo.tests.use_cases.api.points.configuration;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DefaultConfigurationGetting extends ApiUseCase
{

    private ServiceResult serviceResult;

    @Test
    public void test() {
//        serviceResult = new PointsConfigurationRequest(getApiUser()).send();
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

