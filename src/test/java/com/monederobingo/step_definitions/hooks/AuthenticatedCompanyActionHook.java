package com.monederobingo.step_definitions.hooks;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.login.CompanyLoginRequest;
import com.monederobingo.api.client.requests.auth.login.GetTokenRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import cucumber.api.java.Before;
import org.json.JSONObject;

import static java.lang.String.valueOf;

public class AuthenticatedCompanyActionHook {

    private final ApiUser apiUser;

    public AuthenticatedCompanyActionHook(ApiUser apiUser) {
        this.apiUser = apiUser;
    }

    @Before("@authenticated_company_action")
    public final void loginCompanyAndGetApiUser() {
        final JSONObject jsonObject = activateAndLoginUser(registerCompany()).getJSONObject();
        JSONObject token = new GetTokenRequest()
                .withUsername("test@monederobingo.com")
                .withPassword("Password")
                .send();
        apiUser.withKeyAndCompanyIdToken(
                jsonObject.getString("apiKey"),
                valueOf(jsonObject.getInt("companyId")),
                token.getString("access_token"));
    }

    private ServiceResult registerCompany() {
        return new CompanyRegistrationRequest()
                .withCompanyName("company name")
                .setUsername("username")
                .withEmail("test@monederobingo.com")
                .withPassword("Password")
                .withPasswordConfirmation("Password")
                .send();
    }

    private ServiceResult activateAndLoginUser(ServiceResult serviceResultResult) {
        new ActivateCompanyUserRequest().send(serviceResultResult.getExtraInfo());
        return new CompanyLoginRequest()
                .withEmail("test@monederobingo.com")
                .andPassword("Password")
                .send();
    }
}
