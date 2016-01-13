package com.lealpoints.tests.api_client;

public class HttpRequestData {
    private static final String API_URL = "http://test.localhost:9090/";
    private HttpMethod httpMethod = HttpMethod.GET;
    private String body = "{}";
    private String urlPath = "";
    private ApiUser apiUser = new ApiUser("", "0");

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

    public String getUrlPath() {
        return API_URL + urlPath;
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
}
