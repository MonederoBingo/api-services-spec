package com.lealpoints.tests.requests.api.users;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.api_client.HttpMethod;
import com.lealpoints.tests.requests.api.ApiRequest;
import org.json.JSONObject;

public class CompanyUserListingRequest extends ApiRequest {
    private long companyId;

    public CompanyUserListingRequest(ApiUser apiUser) {
        super(apiUser);
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
