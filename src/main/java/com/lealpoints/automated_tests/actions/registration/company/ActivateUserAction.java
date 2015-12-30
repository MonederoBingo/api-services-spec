package com.lealpoints.automated_tests.actions.registration.company;

import com.lealpoints.automated_tests.actions.util.ParserUtil;
import com.lealpoints.automated_tests.api.ApiClient;
import com.lealpoints.automated_tests.api.HttpMethod;
import com.lealpoints.automated_tests.model.ServiceResult;

public class ActivateUserAction {
    public static ServiceResult activate(String activationUrl) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.GET, "company/activate/" + activationUrl,"");
        return ParserUtil.toServiceResult(restResponse);
    }
}
