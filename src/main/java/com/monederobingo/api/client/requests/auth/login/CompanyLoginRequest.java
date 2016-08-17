package com.monederobingo.api.client.requests.auth.login;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.auth.AuthRequest;
import org.json.JSONObject;

public class CompanyLoginRequest extends AuthRequest
{
    private String email = "test@monederobingo.com";
    private String password = "Pa$$w0rd";

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

    public CompanyLoginRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyLoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
