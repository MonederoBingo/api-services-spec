package com.lealpoints.tests.actions.login;

import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class ClientUserLoginAction {
    private static String getJson(RequestData requestData){
        return new JSONObject()
                .put("phoneNumber", requestData.phoneNumber)
                .put("smsKey", requestData.smsKey)
                .put("email", requestData.email)
                .put("password", requestData.password)
                .toString();
    }

    public static ServiceResult loginUser() {
        return loginUser(new RequestData());
    }

    public static ServiceResult loginUser(RequestData data) {
        final String json = getJson(data);
        String restResponse = ApiClient.getRestResponse(HttpMethod.POST, "client/login", json);
        return ParserUtil.toServiceResult(restResponse);
    }

    public static class RequestData {
        private String phoneNumber = "9991112233";
        private String smsKey = "123456";
        private String email = "test@lealpoints.com";
        private String password = "Password";

        public RequestData setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public RequestData setSmsKey(String smsKey) {
            this.smsKey = smsKey;
            return this;
        }

        public RequestData setEmail(String email) {
            this.email = email;
            return this;
        }

        public RequestData setPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
