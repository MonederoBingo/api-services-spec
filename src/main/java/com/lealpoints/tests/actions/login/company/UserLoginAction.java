package com.lealpoints.tests.actions.login.company;

import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class UserLoginAction {
    private static String getJson(String email, String password){
        return new JSONObject()
                .put("email", email)
                .put("password", password)
                .toString();
    }

    public static ServiceResult loginCompanyUser(String email, String password) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.POST, "company/login", getJson(email, password));
        return ParserUtil.toServiceResult(restResponse);
    }
}
