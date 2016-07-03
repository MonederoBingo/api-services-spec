package com.monederobingo.api.client.requests.auth.activation;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.auth.AuthRequest;

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
