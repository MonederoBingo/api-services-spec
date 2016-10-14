package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.notifications.sms.SendMobileAppAdRequest;
import cucumber.api.java8.En;

public class Notifications implements En {
    public Notifications(SendMobileAppAdRequest sendMobileAppAdRequest) {

        And("^User sends send mobile app advertisement request to phone number \"([^\"]*)\"$",
                (String phoneNumber) -> sendMobileAppAdRequest.withPhoneNumber(phoneNumber).send());
    }
}
