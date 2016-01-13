package com.lealpoints.tests.requests.auth.registration;

import com.lealpoints.tests.requests.auth.AuthRequest;
import com.lealpoints.tests.api_client.HttpMethod;
import org.json.JSONObject;

public class ClientRegistrationRequest extends AuthRequest {
    private String phone = "9991112233";

    @Override
    protected String getRequestBody() {
        return new JSONObject().put("phone", phone).toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "client/";
    }

    public ClientRegistrationRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
