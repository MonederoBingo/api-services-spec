package com.lealpoints.automated_tests.actions.registration;

import com.lealpoints.automated_tests.actions.util.ParserUtil;
import com.lealpoints.automated_tests.api.ApiClient;
import com.lealpoints.automated_tests.api.HttpMethod;
import com.lealpoints.automated_tests.model.ServiceResult;

public class CompanyRegistrationAction {
    public static ServiceResult registerCompany(String json) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.POST, "company/register", json);
        return ParserUtil.toServiceResult(restResponse);
    }
}
