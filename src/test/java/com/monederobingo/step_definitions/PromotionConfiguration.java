package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.promotions.PromotionConfigurationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.*;

public class PromotionConfiguration implements En {

    public PromotionConfiguration(PromotionConfigurationRequest promotionConfigurationRequest,
                                  ServiceResultHolder serviceResult) {

        Given("^User sends get promotion configuration request$", promotionConfigurationRequest::send);

        Then("^The user should get (\\d+) required points$", (Integer points) -> {
            assertNotNull(serviceResult.get());
            JSONArray jsonArray = serviceResult.get().getJSONArray();
            assertNotNull(jsonArray);
            assertEquals(1, jsonArray.length());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            assertTrue(jsonObject.has("companyId"));
            assertTrue(jsonObject.has("promotionConfigurationId"));
            assertEquals(1000, jsonObject.getInt("requiredPoints"));
            assertEquals("10% off in your next purchase!", jsonObject.getString("description"));
        });
    }
}
