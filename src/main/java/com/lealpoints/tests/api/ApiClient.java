package com.lealpoints.tests.api;


import java.io.IOException;

public class ApiClient {
    private static final String API_URL = "http://test.localhost:9090/";

    public static String getRestResponse(HttpMethod httpMethod, String path, String json) {
        String response;
        try {
            response = HttpRequestUtil.sendRequestAndGetResponse(httpMethod, json, API_URL + path);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return response;
    }
}
