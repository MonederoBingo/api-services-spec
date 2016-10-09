
package com.monederobingo.step_definitions.domain_verifiers;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
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

        And("^The response should have companyId$",
                () -> assertTrue(serviceResult.getFirstObjectIfArray().has("companyId")));

        And("^The response should have promotionConfigurationId",
                () -> assertTrue(serviceResult.getFirstObjectIfArray().has("promotionConfigurationId")));

        And("^The response should have pointsConfigurationId",
                () -> assertTrue(serviceResult.getFirstObjectIfArray().has("pointsConfigurationId")));

        this.<DataTable>And("^The user should receive the following messages$", (expectedMessages) -> {
            Map<Language, String> messages = expectedMessages.asMap(Language.class, String.class);
            assertEquals(messages.get(ENGLISH), serviceResult.get().getMessage());
            assertEquals(messages.get(ENGLISH), serviceResult.get().getTranslation(ENGLISH));
            assertEquals(messages.get(SPANISH), serviceResult.get().getTranslation(SPANISH));
        });

        And("^The response should have \"([^\"]*)\" as object$",
                (String object) -> assertEquals("100.0", serviceResult.get().getObject()));
    }
}
