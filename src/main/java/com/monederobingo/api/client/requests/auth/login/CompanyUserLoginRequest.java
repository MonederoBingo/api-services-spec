package com.monederobingo.api.client.requests.auth.login;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.auth.AuthRequest;
import org.json.JSONObject;

public class CompanyUserLoginRequest extends AuthRequest
{
    private String email = "test@lealpoints.com";
    private String password = "test@lealpoints.com";

    @Override
    protected String getRequestBody() {
        return new JSONObject()
                .put("email", email)
                .put("password", password)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "company/login";
    }

    public CompanyUserLoginRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyUserLoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}