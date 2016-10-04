package com.monederobingo.api.client.requests.api.users;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.api.ApiRequest;

public class CompanyUserListingRequest extends ApiRequest
{
    private long companyId;

    public CompanyUserListingRequest(ApiUser apiUser, ResultListener resultListener) {
        super(apiUser, resultListener);
        companyId = Long.parseLong(apiUser.getCompanyId());
    }

    @Override
    public String getRequestBody() {
        return null;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getUrlPath() {
        return "/api/v1/company_users/" + companyId;
    }
}
