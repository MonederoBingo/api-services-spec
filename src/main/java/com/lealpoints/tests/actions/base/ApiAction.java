package com.lealpoints.tests.actions.base;

import com.lealpoints.tests.model.ApiUser;
import com.lealpoints.tests.model.ServiceResult;

public abstract class ApiAction {
    private final ApiUser apiUser;

    protected ApiAction(ApiUser apiUser) {
        this.apiUser = apiUser;
    }

    public abstract ServiceResult execute();

    protected ApiUser getApiUser() {
        return apiUser;
    }
}
