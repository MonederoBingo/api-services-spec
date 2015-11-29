package com.lealpoints.automated_tests.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.lang.StringUtils;

public class HttpRequestUtil {
    public static String sendRequestAndGetResponse(HttpMethod httpMethod, String json, String urlPath) throws IOException {
        String response = "";
        HttpURLConnection connection = null;
        try {
            connection = getHttpURLConnection(httpMethod, urlPath);
            if (StringUtils.isNotEmpty(json)) {
                includeBody(json, connection);
            }
            response = getResponse(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }

    private static HttpURLConnection getHttpURLConnection(HttpMethod httpMethod, String urlPath) throws IOException {
        HttpURLConnection connection;
        URL url = new URL(urlPath);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethod.name());
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("language", "en");
        connection.setDoOutput(true);
        return connection;
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
