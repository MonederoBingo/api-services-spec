package com.neerpoints.functional_tests.model;

import com.owlike.genson.GenericType;

public class ServiceResult<T> extends GenericType{
    private final boolean success;
    private final String message;
    private T object;

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ServiceResult(boolean success, String message, T object) {
        this(success, message);
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getObject() {
        return object;
    }
}
