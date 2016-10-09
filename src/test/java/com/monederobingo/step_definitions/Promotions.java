package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.promotions.PromotionGetAvailableByClientRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

import static org.junit.Assert.assertEquals;

public class Promotions implements En {

    public Promotions(PromotionGetAvailableByClientRequest promotionGetAvailableByClientRequest,
                      ServiceResultHolder serviceResult) {

        And("^User sends request to get promotions available by client with phone number \"([^\"]*)\"$",
                (String phoneNumber) ->
                        promotionGetAvailableByClientRequest.withPhoneNumber(phoneNumber).send());

        And("^The response should contain one promotion$",
                () -> assertEquals(1, serviceResult.getJSONArray().length()));

        And("^The promotion should have (\\d+) required points$",
                (Integer points) -> assertEquals(1000,
                        serviceResult.getFirstArrayObject().getDouble("requiredPoints"), 0.00));

        And("^The promotion should have this description: \"([^\"]*)\"$",
                (String description) -> assertEquals(description,
                serviceResult.getFirstArrayObject().getString("description")));
    }
}
