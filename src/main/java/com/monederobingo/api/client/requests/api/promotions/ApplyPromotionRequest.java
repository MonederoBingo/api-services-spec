package com.monederobingo.api.client.requests.api.promotions;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.api.ApiRequest;
import org.json.JSONObject;

public class ApplyPromotionRequest extends ApiRequest
{
    private String phoneNumber = "6661234567";
    private long promotionConfigurationId;

    public ApplyPromotionRequest(ApiUser apiUser) {
        super(apiUser);
    }

    @Override
    protected String getRequestBody() {
        return new JSONObject()
                .put("companyId", getApiUser().getCompanyId())
                .put("phoneNumber", phoneNumber)
                .put("promotionConfigurationId", promotionConfigurationId)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "/api/v1/promotions" ;
    }

    public ApplyPromotionRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ApplyPromotionRequest setPromotionConfigurationId(long promotionConfigurationId) {
        this.promotionConfigurationId = promotionConfigurationId;
        return this;
    }
}
