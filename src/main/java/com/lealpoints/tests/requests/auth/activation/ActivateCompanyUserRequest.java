package com.lealpoints.tests.requests.auth.activation;

import com.lealpoints.tests.requests.auth.AuthRequest;
import com.lealpoints.tests.api_client.HttpMethod;

public class ActivateCompanyUserRequest extends AuthRequest {
    @Override
    protected String getRequestBody() {
        return null;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getUrlPath() {
        return "company/activate/";
    }
}
