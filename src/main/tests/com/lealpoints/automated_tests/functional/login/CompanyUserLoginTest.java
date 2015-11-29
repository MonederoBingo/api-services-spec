package com.lealpoints.automated_tests.functional.login;

import com.lealpoints.automated_tests.functional.BaseApiTest;
import com.lealpoints.automated_tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.automated_tests.model.ServiceResult;
import org.json.JSONObject;
import org.junit.Test;

public class CompanyUserLoginTest extends BaseApiTest {
    @Test
    public void testRegisterCompany() {
        final String companyRegistration = getCompanyRegistrationJson();
        ServiceResult serviceResult = CompanyRegistrationAction.registerCompany(companyRegistration);
    }

    private String getCompanyRegistrationJson() {
        return new JSONObject()
            .put("companyName", "company name")
            .put("urlImageLogo", "images/logo.png")
            .put("userName", "user name")
            .put("email", "test4@email.com")
            .put("password", "Pa$$w0rd")
            .put("passwordConfirmation", "Pa$$w0rd")
            .put("language", "")
            .toString();
    }
}

