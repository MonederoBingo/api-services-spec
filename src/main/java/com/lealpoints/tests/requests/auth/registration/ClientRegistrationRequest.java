package com.lealpoints.tests.requests.auth.registration;

import com.lealpoints.tests.requests.auth.AuthRequest;
import com.lealpoints.tests.api_client.HttpMethod;
import org.json.JSONObject;

public class ClientRegistrationRequest extends AuthRequest {
    private String phoneNumber = "9991112233";

    @Override
    protected String getRequestBody() {
        return new JSONObject().put("phoneNumber", phoneNumber).toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "client/";
    }

    public ClientRegistrationRequest setPhoneNumber(String phone) {
        this.phoneNumber = phone;
        return this;
    }
}
