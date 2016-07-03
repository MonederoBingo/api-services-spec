package com.monederobingo.api.client.requests.api;

import com.monederobingo.api.client.api_client.ApiClient;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.api_client.HttpRequestData;
import com.monederobingo.api.client.util.ParserUtil;

public abstract class ApiRequest {
    private ApiUser apiUser;

    public ApiRequest(ApiUser apiUser) {
        this.apiUser = apiUser;
    }

    public ServiceResult send() {
        final HttpRequestData httpRequestData = getHttpRequestData(apiUser);
        final String restResponse = ApiClient.getRestResponse(httpRequestData);
        return ParserUtil.toServiceResult(restResponse);
    }

    private HttpRequestData getHttpRequestData(ApiUser apiUser) {
        return new HttpRequestData()
                .setHttpMethod(getHttpMethod())
                .setApiUser(apiUser)
                .setBody(getRequestBody())
                .setUrlPath(getUrlPath());
    }

    public ApiUser getApiUser() {
        return apiUser;
    }

    protected abstract String getRequestBody();

    protected abstract HttpMethod getHttpMethod();

    protected abstract String getUrlPath();
}
