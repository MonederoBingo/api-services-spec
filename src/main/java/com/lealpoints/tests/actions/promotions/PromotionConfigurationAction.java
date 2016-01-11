package com.lealpoints.tests.actions.promotions;

import com.lealpoints.tests.actions.base.ApiAction;
import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ApiUser;
import com.lealpoints.tests.model.ServiceResult;

public class PromotionConfigurationAction extends ApiAction {
    public PromotionConfigurationAction(ApiUser apiUser) {
        super(apiUser);
    }

    @Override
    public ServiceResult execute() {
        final ApiUser apiUser = getApiUser();
        final String restResponse = ApiClient.getRestResponse(HttpMethod.GET, "/v1/promotion_configuration/" +
                apiUser.getCompanyId(), "");
        return ParserUtil.toServiceResult(restResponse);
    }
}
