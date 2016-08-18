/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.domain_holders;

import com.monederobingo.api.client.model.ServiceResult;
import org.json.JSONObject;

public class ServiceResultHolder {
    private ServiceResult serviceResult = ServiceResult.NULL;

    public ServiceResult get() {
        return serviceResult;
    }

    public void set(ServiceResult serviceResult) {
        this.serviceResult = serviceResult;
    }

    public JSONObject getJSONObject() {
        return serviceResult.getJSONObject();
    }
}
