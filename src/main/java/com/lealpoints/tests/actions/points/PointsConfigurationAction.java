package com.lealpoints.tests.actions.points;

import com.lealpoints.tests.actions.base.ApiAction;
import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ApiUser;
import com.lealpoints.tests.model.ServiceResult;

public class PointsConfigurationAction extends ApiAction {
    public PointsConfigurationAction(ApiUser apiUser) {
        super(apiUser);
    }

    @Override
    public ServiceResult execute() {
        final ApiUser apiUser = getApiUser();
        final String restResponse = ApiClient.getRestResponse(HttpMethod.GET, "/v1/points_configuration/" +
                apiUser.getCompanyId(), "");
        return ParserUtil.toServiceResult(restResponse);
    }
}
