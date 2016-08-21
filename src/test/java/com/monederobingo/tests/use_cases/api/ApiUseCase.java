package com.monederobingo.tests.use_cases.api;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.activation.ActivateCompanyUserRequest;
import com.monederobingo.api.client.requests.auth.login.CompanyLoginRequest;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import com.monederobingo.tests.use_cases.UseCase;
import org.json.JSONObject;
import org.junit.Before;

public abstract class ApiUseCase extends UseCase
{
    private ApiUser apiUser;
    private String username = "Admin";
    private String email = "test@monederobingo.com";

    @Before
    public final void baseApiSetUp() {
        apiUser = loginCompanyAndGetApiUser();
    }

    public ApiUser loginCompanyAndGetApiUser() {
        final ServiceResult registrationResult = registerCompany();
        final ServiceResult loginResult = activateAndLoginUser(registrationResult);
        final JSONObject jsonObject = loginResult.getJSONObject();
        final String apiKey = jsonObject.getString("apiKey");
        final Integer companyId = jsonObject.getInt("companyId");
        return new ApiUser(apiKey, String.valueOf(companyId));
    }

    private ServiceResult registerCompany() {
        return new CompanyRegistrationRequest()
                .withCompanyName(getCompanyName())
                .setUsername(username)
                .withEmail(email)
                .withPassword("Password")
                .withPasswordConfirmation("Password")
                .send();
    }

    protected String getCompanyName() {
        return "company name";
    }

    private ServiceResult activateAndLoginUser(ServiceResult serviceResultResult) {
        new ActivateCompanyUserRequest().send(serviceResultResult.getExtraInfo());
        return new CompanyLoginRequest()
                .withEmail(email)
                .andPassword("Password")
                .send();
    }

    public ApiUser getApiUser() {
        return apiUser;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
