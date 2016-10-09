package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.promotions.PromotionConfigurationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

import static org.junit.Assert.*;

public class PromotionConfiguration implements En {

    public PromotionConfiguration(PromotionConfigurationRequest promotionConfigurationRequest,
                                  ServiceResultHolder serviceResult) {

        Given("^User sends get promotion configuration request$", promotionConfigurationRequest::send);

        Then("^Response should have only one configuration$",
                () -> assertEquals(1, serviceResult.getJSONArray().length()));

        And("^The configuration should have this description: \"([^\"]*)\"$",
                (String description) -> assertEquals(description,
                        serviceResult.getFirstObjectIfArray().getString("description")));

        And("^The configuration should have (\\d+) required points$",
                (Integer points) ->
                        assertEquals(1000, serviceResult.getFirstObjectIfArray().getInt("requiredPoints")));
    }
}
