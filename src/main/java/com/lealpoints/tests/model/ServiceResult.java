package com.lealpoints.tests.model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceResult {
    private final boolean success;
    private final ServiceMessage serviceMessage;
    private String extraInfo;
    private final String object;

    public ServiceResult(boolean success, ServiceMessage serviceMessage, String object, String extraInfo) {
        this.success = success;
        this.serviceMessage = serviceMessage;
        this.object = object;
        this.extraInfo = extraInfo;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return serviceMessage.getMessage();
    }

    public String getTranslation(Language language) {
        return serviceMessage.getTranslation(language);
    }

    public JSONObject getJSONObject() {
        return new JSONObject(object);
    }

    public JSONArray getJSONArray() {
        return new JSONArray(object);
    }

    public String getObject() {
        return object;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}
