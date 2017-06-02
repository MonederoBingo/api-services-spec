package com.monederobingo.api.client.requests.auth.login;

import static com.monederobingo.api.client.api_client.HttpMethod.POST;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.auth.OAuth2Request;

public class GetTokenRequest extends OAuth2Request
{
    private String username;
    private String password;

    @Override
    protected String getRequestBody()
    {
        return "grant_type=password&client_id=monederobingo&username=" + username + "&password=" + password;
    }

    @Override
    protected HttpMethod getHttpMethod()
    {
        return POST;
    }

    @Override
    protected String getUrlPath()
    {
        return "oauth/token";
    }

    public GetTokenRequest withUsername(String username)
    {
        this.username = username;
        return this;
    }

    public GetTokenRequest withPassword(String password)
    {
        this.password = password;
        return this;
    }
}
