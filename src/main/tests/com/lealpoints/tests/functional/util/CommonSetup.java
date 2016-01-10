package com.lealpoints.tests.functional.util;

import com.lealpoints.tests.actions.login.CompanyUserLoginAction;
import com.lealpoints.tests.actions.registration.ActivateCompanyUserAction;
import com.lealpoints.tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.tests.model.ApiUser;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class CommonSetup {
    public static ApiUser loginCompanyAndGetApiKey() {
        final ServiceResult registrationResult = registerCompany();
        final ServiceResult loginResult = activateAndLoginUser(registrationResult);
        final JSONObject jsonObject = loginResult.getJSONObject();
        final String apiKey = jsonObject.getString("apiKey");
        final Integer companyId = jsonObject.getInt("companyId");
        return new ApiUser(apiKey, companyId.toString());
    }

    private static ServiceResult activateAndLoginUser(ServiceResult serviceResultResult) {
        ActivateCompanyUserAction.activate(serviceResultResult.getExtraInfo());
        return CompanyUserLoginAction.loginUser("test@lealpoints.com", "Password");
    }

    private static ServiceResult registerCompany() {
        final CompanyRegistrationAction.RequestData requestData = CompanyRegistrationAction.getRequestData()
                .setEmail("test@lealpoints.com")
                .setPassword("Password")
                .setPasswordConfirmation("Password");
        return CompanyRegistrationAction.registerCompany(requestData);
    }
}
