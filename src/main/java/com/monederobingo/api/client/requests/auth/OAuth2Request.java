package com.monederobingo.api.client.requests.auth;

import static com.monederobingo.api.client.api_client.ApiClient.getRestResponse;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.api_client.HttpRequestData;

import java.util.Base64;

import org.json.JSONObject;

public abstract class OAuth2Request
{
    public JSONObject send() {
        return new JSONObject(getRestResponse(getHttpRequestData()));
    }

    private HttpRequestData getHttpRequestData() {
        return new HttpRequestData()
                .setHttpMethod(getHttpMethod())
                .setBody(getRequestBody())
                .setUrlPath(getUrlPath())
                .setContentType("application/x-www-form-urlencoded")
                .setAuthorization("Basic " + new String(Base64.getEncoder().encode("monederobingo:monederobingosecret".getBytes())))
                .setApiUrl("http://localhost:9000/");
    }

    protected abstract String getRequestBody();

    protected abstract HttpMethod getHttpMethod();

    protected abstract String getUrlPath();
}
