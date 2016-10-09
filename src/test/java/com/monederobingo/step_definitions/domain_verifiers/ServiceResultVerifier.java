
package com.monederobingo.step_definitions.domain_verifiers;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

import java.util.Map;

import static com.monederobingo.api.client.model.Language.ENGLISH;
import static com.monederobingo.api.client.model.Language.SPANISH;
import static org.junit.Assert.*;

public class ServiceResultVerifier implements En {

    public ServiceResultVerifier(ServiceResultHolder serviceResult) {
        Then("^The response should be successful$", () ->
                assertTrue(serviceResult.get().isSuccess()));

        Then("^The response should not be successful$", () ->
                assertFalse(serviceResult.get().isSuccess()));

        And("^Response should have companyId$",
                () -> assertTrue(serviceResult.getFirstObjectFromArray().has("companyId")));

        And("^Response should have promotionConfigurationId",
                () -> assertTrue(serviceResult.getFirstObjectFromArray().has("promotionConfigurationId")));

        this.<DataTable>And("^The user should receive the following messages$", (expectedMessages) -> {
            Map<Language, String> messages = expectedMessages.asMap(Language.class, String.class);
            assertEquals(messages.get(ENGLISH), serviceResult.get().getMessage());
            assertEquals(messages.get(ENGLISH), serviceResult.get().getTranslation(ENGLISH));
            assertEquals(messages.get(SPANISH), serviceResult.get().getTranslation(SPANISH));
        });
    }
}
