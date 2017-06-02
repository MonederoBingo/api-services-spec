package com.monederobingo.api.client.api_client;

public class HttpRequestData {
    private String apiUrl;
    private HttpMethod httpMethod = HttpMethod.GET;
    private String body = "{}";
    private String urlPath = "";
    private ApiUser apiUser = new ApiUser();
    private String contentType;
    private String authorization;

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public HttpRequestData setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getBody() {
        return body;
    }

    public HttpRequestData setBody(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestData setApiUrl(String apiUrl)
    {
        this.apiUrl = apiUrl;
        return this;
    }

    public String getUrlPath() {
        return this.apiUrl + urlPath;
    }

    public HttpRequestData setUrlPath(String urlPath) {
        this.urlPath = urlPath;
        return this;
    }

    public ApiUser getApiUser() {
        return apiUser;
    }

    public HttpRequestData setApiUser(ApiUser apiUser) {
        this.apiUser = apiUser;
        return this;
    }

    public HttpRequestData setContentType(String contentType)
    {
        this.contentType = contentType;
        return this;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getAuthorization()
    {
        return authorization;
    }

    public HttpRequestData setAuthorization(String authentication)
    {
        this.authorization = authentication;
        return this;
    }
}
