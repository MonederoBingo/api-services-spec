package com.monederobingo.api.client.requests.api.users;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.api.ApiRequest;
import org.json.JSONObject;

public class CompanyUserRegistrationRequest extends ApiRequest
{
    private String name = "user1";
    private String email = "user1@gmail.com";

    public CompanyUserRegistrationRequest(ApiUser apiUser, ResultListener resultListener) {
        super(apiUser, resultListener);
    }

    @Override
    public String getRequestBody() {
        return new JSONObject()
                .put("companyId", apiUser.getCompanyId())
                .put("name", name)
                .put("email", email)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "/api/v1/company_users/register";
    }

    public CompanyUserRegistrationRequest withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyUserRegistrationRequest setSaleKey(String email) {
        this.email = email;
        return this;
    }

    public CompanyUserRegistrationRequest andEmail(String email) {
        this.email = email;
        return this;
    }
}
