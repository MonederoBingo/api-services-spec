package com.monederobingo.step_definitions.domain_holders;

import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.ResultListener;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceResultHolder implements ResultListener {
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

    public JSONArray getJSONArray() {
        return serviceResult.getJSONArray();
    }

    public JSONObject getFirstObjectFromArray() {
        return serviceResult.getJSONArray().getJSONObject(0);
    }
}
