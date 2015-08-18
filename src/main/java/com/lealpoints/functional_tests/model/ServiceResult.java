package com.lealpoints.functional_tests.model;

public class ServiceResult{
    private final boolean success;
    private final String message;
    private String object;

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ServiceResult(boolean success, String message, String object) {
        this(success, message);
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
