package com.monederobingo.api.client.util;

import com.monederobingo.api.client.model.ServiceMessage;
import com.monederobingo.api.client.model.ServiceResult;
import org.json.JSONObject;

public class ParserUtil {
    public static ServiceResult toServiceResult(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            boolean success = jsonObject.getBoolean("success");
            ServiceMessage serviceMessage = parseServiceMessage(jsonObject.getJSONObject("serviceMessage"));
            Object object = "";
            if (jsonObject.has("object")) {
                object = jsonObject.get("object");
            }
            String extraInfo = jsonObject.has("extraInfo") ? jsonObject.getString("extraInfo") : "";
            return new ServiceResult(success, serviceMessage, object.toString(), extraInfo);
        } catch (Exception ex) {
            throw new RuntimeException("Error when parsing JSON to Service Result. JSON String: " + json, ex);
        }

    }

    private static ServiceMessage parseServiceMessage(JSONObject jsonObject) {
        ServiceMessage serviceMessage = new ServiceMessage(jsonObject.getString("message"));
        JSONObject translations = jsonObject.getJSONObject("translations");
        for (String s : translations.keySet()) {
            serviceMessage.addTranslation(s, translations.getString(s));
        }
        return serviceMessage;
    }
}
