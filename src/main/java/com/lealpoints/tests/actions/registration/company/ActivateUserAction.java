package com.lealpoints.tests.actions.registration.company;

import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ServiceResult;

public class ActivateUserAction {
    public static ServiceResult activate(String activationUrl) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.GET, "company/activate/" + activationUrl,"");
        return ParserUtil.toServiceResult(restResponse);
    }
}
