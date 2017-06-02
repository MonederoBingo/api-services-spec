package com.monederobingo.api.client.api_client;

public class ApiUser {
    private String apiKey;
    private String companyId;
    private String apiToken;

    public void withKeyAndCompanyIdToken(String apiKey, String companyId, String apiToken) {
        this.apiKey = apiKey;
        this.companyId = companyId;
        this.apiToken = apiToken;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getApiToken()
    {
        return apiToken;
    }
}
