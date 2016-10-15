package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.users.CompanyUserRegistrationRequest;
import cucumber.api.java8.En;

public class CompanyUserRegistration implements En {
    public CompanyUserRegistration(CompanyUserRegistrationRequest companyUserRegistrationRequest) {
        Given("^User sends company registration request with name \"([^\"]*)\" and email \"([^\"]*)\"$",
                (String name, String email) -> companyUserRegistrationRequest
                        .withName(name)
                        .andEmail(email)
                        .send());
    }
}
