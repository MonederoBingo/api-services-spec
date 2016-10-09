package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.points.PointsAwardingRequest;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class PointsAwarding implements En {

    public PointsAwarding(PointsAwardingRequest pointsAwardingRequest) {

        Given("^User sends points awarding request with phone number \"([^\"]*)\" and (\\d+) amount$",
                (String phoneNumber, Integer amount) -> pointsAwardingRequest
                        .withPhoneNumber(phoneNumber)
                        .andSaleAmount(amount)
                        .send());
    }

}
