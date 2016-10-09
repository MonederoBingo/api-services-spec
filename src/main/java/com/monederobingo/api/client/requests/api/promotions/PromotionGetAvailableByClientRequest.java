package com.monederobingo.api.client.requests.api.promotions;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.api.ApiRequest;

public class PromotionGetAvailableByClientRequest extends ApiRequest
{

    private String phoneNumber = "6661234567";

    public PromotionGetAvailableByClientRequest(ApiUser apiUser, ResultListener resultListener) {
        super(apiUser, resultListener);
    }

    @Override
    protected String getRequestBody() {
        return null;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getUrlPath() {
        return "/api/v1/promotion_configuration/" + getApiUser().getCompanyId() + "/" + phoneNumber ;
    }

    public PromotionGetAvailableByClientRequest withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
