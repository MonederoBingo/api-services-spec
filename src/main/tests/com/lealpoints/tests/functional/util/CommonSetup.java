package com.lealpoints.tests.functional.util;

import com.lealpoints.tests.requests.auth.login.CompanyUserLoginRequest;
import com.lealpoints.tests.requests.auth.activation.ActivateCompanyUserRequest;
import com.lealpoints.tests.requests.auth.registration.CompanyRegistrationRequest;
import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class CommonSetup {
    public static ApiUser loginCompanyAndGetApiKey() {
        final ServiceResult registrationResult = registerCompany();
        final ServiceResult loginResult = activateAndLoginUser(registrationResult);
        final JSONObject jsonObject = loginResult.getJSONObject();
        final String apiKey = jsonObject.getString("apiKey");
        final Integer companyId = jsonObject.getInt("companyId");
        return new ApiUser(apiKey, String.valueOf(companyId));
    }

    private static ServiceResult activateAndLoginUser(ServiceResult serviceResultResult) {
        new ActivateCompanyUserRequest().send(serviceResultResult.getExtraInfo());
        return new CompanyUserLoginRequest()
                .setEmail("test@lealpoints.com")
                .setPassword("Password")
                .send();
    }

    private static ServiceResult registerCompany() {
        return new CompanyRegistrationRequest()
                .setEmail("test@lealpoints.com")
                .setPassword("Password")
                .setPasswordConfirmation("Password")
                .send();
    }
}
