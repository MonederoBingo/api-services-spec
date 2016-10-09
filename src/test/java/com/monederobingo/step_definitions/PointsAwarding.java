package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.points.PointsAwardingRequest;
import cucumber.api.java8.En;

public class PointsAwarding implements En {

    public PointsAwarding(PointsAwardingRequest pointsAwardingRequest) {

        Given("^User sends points awarding request with phone number \"([^\"]*)\", (\\d+) amount and sale key \"([^\"]*)\"$",
                (String phoneNumber, Integer amount, String saleKey) -> pointsAwardingRequest
                        .withPhoneNumber(phoneNumber)
                        .andSaleAmount(amount)
                        .andSaleKey(saleKey)
                        .send());
    }
}