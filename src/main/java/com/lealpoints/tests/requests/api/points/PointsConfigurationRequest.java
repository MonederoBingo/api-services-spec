package com.lealpoints.tests.requests.api.points;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.requests.api.ApiRequest;
import com.lealpoints.tests.api_client.HttpMethod;

public class PointsConfigurationRequest extends ApiRequest {

    public PointsConfigurationRequest(ApiUser apiUser) {
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
        return "/api/v1/points_configuration/" + getApiUser().getCompanyId();
    }
}
