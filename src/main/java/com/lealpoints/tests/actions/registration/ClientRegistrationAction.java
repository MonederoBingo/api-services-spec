package com.lealpoints.tests.actions.registration;

import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class ClientRegistrationAction {
    private static String getJson(RequestData requestData) {
        return new JSONObject().put("phone", requestData.phoneNumber).toString();
    }

    public static ServiceResult registerClient() {
        return registerClient(new RequestData());
    }

    public static ServiceResult registerClient(RequestData requestData) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.POST, "client/", getJson(requestData));
        return ParserUtil.toServiceResult(restResponse);
    }

    public static RequestData getRequestData() {
        return new RequestData();
    }

    public static class RequestData {
        private String phoneNumber = "9991112233";

        public RequestData setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
    }
}
