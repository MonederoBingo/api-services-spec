package com.monederobingo.api.client.requests.api.promotions;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.api.ApiRequest;
import com.monederobingo.api.client.api_client.ApiUser;

public class PromotionConfigurationRequest extends ApiRequest
{

    public PromotionConfigurationRequest(ApiUser apiUser) {
        super(apiUser);
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
        return "/api/v1/promotion_configuration/" + getApiUser().getCompanyId();
    }


}
