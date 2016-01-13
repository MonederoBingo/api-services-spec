package com.lealpoints.tests.requests.auth;

import com.lealpoints.tests.api_client.ApiClient;
import com.lealpoints.tests.api_client.HttpMethod;
import com.lealpoints.tests.api_client.HttpRequestData;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.util.ParserUtil;

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
