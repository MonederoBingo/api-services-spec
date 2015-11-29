package com.lealpoints.automated_tests.actions.login;

import com.lealpoints.automated_tests.api.ApiClient;
import com.lealpoints.automated_tests.api.HttpMethod;

public class CompanyUserLoginAction {
    public static String loginCompanyUser(String json) {
        return ApiClient.getRestResponse(HttpMethod.POST, json, "company/register");
    }
}
