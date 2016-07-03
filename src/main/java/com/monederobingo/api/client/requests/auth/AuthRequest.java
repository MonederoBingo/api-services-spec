package com.monederobingo.api.client.requests.auth;

import com.monederobingo.api.client.api_client.ApiClient;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.api_client.HttpRequestData;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.util.ParserUtil;

public abstract class AuthRequest {

    private String _urlParameters;

    public ServiceResult send(String urlParameters) {
        _urlParameters = urlParameters;
        final HttpRequestData httpRequestData = getHttpRequestData();
        final String restResponse = ApiClient.getRestResponse(httpRequestData);
        return ParserUtil.toServiceResult(restResponse);
    }

    public ServiceResult send() {
        return send("");
    }

    private HttpRequestData getHttpRequestData() {
        return new HttpRequestData()
                .setHttpMethod(getHttpMethod())
                .setBody(getRequestBody())
                .setUrlPath(getUrlPath() + _urlParameters);
    }

    protected abstract String getRequestBody();

    protected abstract HttpMethod getHttpMethod();

    protected abstract String getUrlPath();
}
