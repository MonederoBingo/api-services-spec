package com.monederobingo.api.client.requests.auth.registration;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.auth.AuthRequest;
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

    public ClientRegistrationRequest withPhoneNumber(String phone) {
        this.phoneNumber = phone;
        return this;
    }
}
