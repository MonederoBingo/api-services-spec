package com.monederobingo.api.client.api_client;

import static java.nio.charset.Charset.forName;
import static java.util.Objects.nonNull;

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
        String response;
        HttpURLConnection connection = null;
        try {
            Map<String, String> headers = getHeaders(httpRequestData);
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

    private static Map<String, String> getHeaders(HttpRequestData httpRequestData) {
        Map<String, String> headers = new HashMap<>();
        if (httpRequestData == null || httpRequestData.getApiUser() == null) return headers;
        if(nonNull(httpRequestData.getApiUser().getCompanyId()))
        {
            headers.put("User-Id", httpRequestData.getApiUser().getCompanyId());
        }
        if(nonNull(httpRequestData.getApiUser().getApiKey()))
        {
            headers.put("Api-Key", httpRequestData.getApiUser().getApiKey());
        }
        if(nonNull(httpRequestData.getAuthorization()) && httpRequestData.getAuthorization().length() > 0)
        {
            headers.put("Authorization", httpRequestData.getAuthorization());
        }
        headers.put("Content-Type", httpRequestData.getContentType());
        return headers;
    }

    private static HttpURLConnection getHttpURLConnection(HttpMethod httpMethod, String urlPath,
                                                          Map<String, String> headers) throws IOException {
        HttpURLConnection connection;
        URL url = new URL(urlPath);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethod.name());
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

    private static void includeBody(String body, HttpURLConnection connection) throws IOException {
        DataOutputStream stream = null;
        try {
            stream = new DataOutputStream(connection.getOutputStream());
            stream.writeBytes(body);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String getResponse(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        String response;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, forName("UTF-8")))) {
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
