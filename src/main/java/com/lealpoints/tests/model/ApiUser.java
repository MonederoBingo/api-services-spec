package com.lealpoints.tests.model;

public class ApiUser {
    private final String apiKey;
    private final String companyId;

    public ApiUser(String apiKey, String companyId) {
        this.apiKey = apiKey;
        this.companyId = companyId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getCompanyId() {
        return companyId;
    }
}
