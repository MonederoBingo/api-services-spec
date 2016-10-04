package com.monederobingo.api.client.api_client;

public class ApiUser {
    private String apiKey;
    private String companyId;

    String getApiKey() {
        return apiKey;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void withKeyAndCompanyId(String apiKey, String companyId) {
        this.apiKey = apiKey;
        this.companyId = companyId;
    }
}
