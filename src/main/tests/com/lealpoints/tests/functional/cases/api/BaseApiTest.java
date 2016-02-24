package com.lealpoints.tests.functional.cases.api;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.functional.BaseTest;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import org.json.JSONObject;
import org.junit.Before;

public abstract class BaseApiTest extends BaseTest {
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
                .setCompanyName(getCompanyName())
                .setUsername(username)
                .setEmail(email)
                .setPassword("Password")
                .setPasswordConfirmation("Password")
                .send();
    }

    protected String getCompanyName() {
        return "company name";
    }

    private ServiceResult activateAndLoginUser(ServiceResult serviceResultResult) {
        new ActivateCompanyUserRequest().send(serviceResultResult.getExtraInfo());
        return new CompanyUserLoginRequest()
                .setEmail(email)
                .setPassword("Password")
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
