package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.points.PointsConfigurationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;

import static org.junit.Assert.assertEquals;

public class PointsConfiguration implements En {

    public PointsConfiguration(PointsConfigurationRequest pointsConfigurationRequest,
                               ServiceResultHolder serviceResult) {

        Given("^User sends get points configuration request$",
                pointsConfigurationRequest::send);

        And("^The response should have required amount (\\d+)$",
                (Integer amount) -> assertEquals(1, serviceResult.getJSONObject().getInt("requiredAmount")));

        And("^The response should have points to earn (\\d+)$",
                (Integer points) -> assertEquals(1, serviceResult.getJSONObject().getInt("pointsToEarn")));
    }
}
