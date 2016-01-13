package com.lealpoints.tests.api_client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class HttpRequestUtil {
    public static String sendRequestAndGetResponse(HttpRequestData httpRequestData) throws IOException {
        String response = "";
        HttpURLConnection connection = null;
        try {
            Map<String, String> headers = getHeaders(httpRequestData.getApiUser());
            connection = getHttpURLConnection(httpRequestData.getHttpMethod(), httpRequestData.getUrlPath(), headers);
            if (StringUtils.isNotEmpty(httpRequestData.getBody())) {
                includeBody(httpRequestData.getBody(), connection);
            }
            response = getResponse(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }

    private static Map<String, String> getHeaders(ApiUser apiUser) {
        Map<String, String> headers = new HashMap<>();
        if (apiUser == null) return headers;
        headers.put("User-Id", apiUser.getCompanyId());
        headers.put("Api-Key", apiUser.getApiKey());
        return headers;
    }

    private static HttpURLConnection getHttpURLConnection(HttpMethod httpMethod, String urlPath,
                                                          Map<String, String> headers) throws IOException {
        HttpURLConnection connection;
        URL url = new URL(urlPath);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethod.name());
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("language", "en");
        setHeadersToConnection(headers, connection);
        connection.setDoOutput(true);
        return connection;
    }

    private static void setHeadersToConnection(Map<String, String> headers, HttpURLConnection connection) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            connection.setRequestProperty(header.getKey(), header.getValue());
        }
    }

    private static void includeBody(String json, HttpURLConnection connection) throws IOException {
        DataOutputStream stream = null;
        try {
            stream = new DataOutputStream(connection.getOutputStream());
            stream.writeBytes(json);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String getResponse(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        String response;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            response = readResponse(br);
        }
        return response;
    }

    private static String readResponse(BufferedReader bufferedReader) throws IOException {
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        return response.toString();
    }
}
