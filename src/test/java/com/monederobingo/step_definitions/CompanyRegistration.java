
package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class CompanyRegistration implements En {

    public CompanyRegistration(CompanyRegistrationRequest companyRegistrationRequest) {

        Given("^User provides correct company registration information$", () -> {
        });

        Given("^User provides empty company name$", () ->
                companyRegistrationRequest.withCompanyName(""));

        Given("^User provides empty email$", () ->
                companyRegistrationRequest.withEmail(""));

        Given("^User provides existent email$", () -> {
            new CompanyRegistrationRequest().withEmail("same@email.com").send();
            companyRegistrationRequest.withEmail("same@email.com");
        });

        Given("^User provides invalid email$", () ->
                companyRegistrationRequest.withEmail("invalid@email.com."));

        Given("^User provides empty language$", () ->
                companyRegistrationRequest.withLanguage(""));

        Given("^User provides empty password$", () ->
                companyRegistrationRequest.withPassword(""));

        Given("^User provides empty password confirmation$", () ->
                companyRegistrationRequest.withPasswordConfirmation(""));

        Given("^User provides different password confirmation$", () ->
                companyRegistrationRequest
                        .withPassword("password")
                        .withPasswordConfirmation("different_password"));
    }
}
