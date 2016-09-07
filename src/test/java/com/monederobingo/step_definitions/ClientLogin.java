package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.login.ClientLoginRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.java8.En;
import cucumber.api.java8.StepdefBody.A0;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ClientLogin implements En {
    public ClientLogin(ClientLoginRequest clientLoginRequest,
                       ServiceResultHolder serviceResult) {

        Given("^User provides correct client login information$", () ->
                clientLoginRequest
                        .withPhoneNumber("9991112233")
                        .setSmsKey(serviceResult.get().getObject()));

        When("^User sends client login request$", (A0) clientLoginRequest::send);

        And("^The user should should get api key$", () -> {
            assertTrue(serviceResult.getJSONObject().has("apiKey"));
            assertNotEquals("", serviceResult.getJSONObject().getString("apiKey"));
        });
    }
}
