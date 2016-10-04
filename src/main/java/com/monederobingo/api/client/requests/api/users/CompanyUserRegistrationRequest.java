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
    private long companyId;

    public CompanyUserRegistrationRequest(ApiUser apiUser, ResultListener resultListener) {
        super(apiUser, resultListener);
        companyId = Long.parseLong(apiUser.getCompanyId());
    }

    @Override
    public String getRequestBody() {
        return new JSONObject()
                .put("companyId", companyId)
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

    public CompanyUserRegistrationRequest setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyUserRegistrationRequest setSaleKey(String email) {
        this.email = email;
        return this;
    }

    public CompanyUserRegistrationRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}
