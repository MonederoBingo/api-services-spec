package com.lealpoints.tests.functional.util;

import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class CommonSetup {

    public static ApiUser loginCompanyAndGetApiUser(String username, String email) {
        final ServiceResult registrationResult = registerCompany(username, email);
        final ServiceResult loginResult = activateAndLoginUser(registrationResult, email);
        final JSONObject jsonObject = loginResult.getJSONObject();
        final String apiKey = jsonObject.getString("apiKey");
        final Integer companyId = jsonObject.getInt("companyId");
        return new ApiUser(apiKey, String.valueOf(companyId));
    }

    public static ApiUser loginCompanyAndGetApiUser() {
        return loginCompanyAndGetApiUser("Admin", "test@monederobingo.com");
    }

    private static ServiceResult registerCompany(String username, String email) {
        return new CompanyRegistrationRequest()
                .setUsername(username)
                .setEmail(email)
                .setPassword("Password")
                .setPasswordConfirmation("Password")
                .send();
    }

    private static ServiceResult activateAndLoginUser(ServiceResult serviceResultResult, String email) {
        new ActivateCompanyUserRequest().send(serviceResultResult.getExtraInfo());
        return new CompanyUserLoginRequest()
                .setEmail(email)
                .setPassword("Password")
                .send();
    }
}
