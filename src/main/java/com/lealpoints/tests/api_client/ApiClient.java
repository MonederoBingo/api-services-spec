package com.lealpoints.tests.api_client;


import java.io.IOException;

public class ApiClient {
    public static String getRestResponse(HttpRequestData httpRequestData) {
        String response;
        try {
            response = HttpRequestUtil.sendRequestAndGetResponse(httpRequestData);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return response;
    }
}
