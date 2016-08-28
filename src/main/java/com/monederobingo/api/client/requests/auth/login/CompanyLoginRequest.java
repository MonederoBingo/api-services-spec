package com.monederobingo.api.client.requests.auth.login;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.auth.AuthRequest;
import org.json.JSONObject;

public class CompanyLoginRequest extends AuthRequest {
    private String email = "test@monederobingo.com";
    private String password = "Pa$$w0rd";

    public CompanyLoginRequest() {
        super(ResultListener.NULL);
    }

    public CompanyLoginRequest(ResultListener resultListener) {
        super(resultListener);
    }

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

    public CompanyLoginRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyLoginRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    public CompanyLoginRequest andPassword(String password) {
        return withPassword(password);
    }
}
