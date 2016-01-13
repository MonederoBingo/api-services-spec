package com.lealpoints.tests.requests.api.promotions;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.api_client.HttpMethod;
import com.lealpoints.tests.requests.api.ApiRequest;

public class PromotionConfigurationRequest extends ApiRequest {

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
