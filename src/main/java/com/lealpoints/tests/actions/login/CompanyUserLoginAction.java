package com.lealpoints.tests.actions.login;

import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class CompanyUserLoginAction {
    private static String getJson(String email, String password){
        return new JSONObject()
                .put("email", email)
                .put("password", password)
                .toString();
    }

    public static ServiceResult loginUser(String email, String password) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.POST, "company/login", getJson(email, password));
        return ParserUtil.toServiceResult(restResponse);
    }
}
