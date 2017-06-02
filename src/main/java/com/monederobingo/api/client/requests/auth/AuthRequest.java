package com.monederobingo.api.client.requests.auth;

import com.monederobingo.api.client.api_client.ApiClient;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.api_client.HttpRequestData;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.ResultListener;

import static com.monederobingo.api.client.util.ParserUtil.toServiceResult;

public abstract class AuthRequest {

    private String urlParameters;
    private ResultListener resultListener;

    public AuthRequest(ResultListener resultListener) {
        this.resultListener = resultListener;
    }

    public ServiceResult send(String urlParameters) {
        this.urlParameters = urlParameters;
        final HttpRequestData httpRequestData = getHttpRequestData();
        final String restResponse = ApiClient.getRestResponse(httpRequestData);
        ServiceResult serviceResult = toServiceResult(restResponse);
        resultListener.set(serviceResult);
        return serviceResult;
    }

    public ServiceResult send() {
        return send("");
    }

    private HttpRequestData getHttpRequestData() {
        return new HttpRequestData()
                .setHttpMethod(getHttpMethod())
                .setBody(getRequestBody())
                .setUrlPath(getUrlPath() + urlParameters)
                .setContentType("application/json")
                .setApiUrl("http://test.localhost:9090/");
    }

    protected abstract String getRequestBody();

    protected abstract HttpMethod getHttpMethod();

    protected abstract String getUrlPath();
}
