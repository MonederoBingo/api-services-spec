package com.lealpoints.automated_tests.model;

public class ServiceResult {
    private final boolean success;
    private final String message;
    private final String object;

    public ServiceResult(boolean success, String message, String object) {
        this.success = success;
        this.message = message;
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getObject() {
        return object;
    }
}
