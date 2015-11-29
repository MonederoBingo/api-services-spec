package com.lealpoints.automated_tests.actions.util;

import com.lealpoints.automated_tests.model.ServiceResult;
import org.json.JSONObject;

public class ParserUtil {
    public static ServiceResult toServiceResult(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            boolean success = jsonObject.getBoolean("success");
            String message = jsonObject.getString("message");
            String object = jsonObject.getString("object");
            return new ServiceResult(success, message, object);
        } catch (Exception ex) {
            throw new RuntimeException("Error when parsing JSON to Service Result. JSON String: " + json, ex);
        }

    }
}
