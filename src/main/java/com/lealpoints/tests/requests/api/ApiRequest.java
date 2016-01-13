package com.lealpoints.tests.requests.api;

import com.lealpoints.tests.api_client.ApiClient;
import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.api_client.HttpMethod;
import com.lealpoints.tests.api_client.HttpRequestData;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.util.ParserUtil;

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
