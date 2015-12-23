package com.lealpoints.automated_tests.model;

public class ServiceResult {
    private final boolean success;
    private final ServiceMessage serviceMessage;
    private final String object;

    public ServiceResult(boolean success, ServiceMessage serviceMessage, String object) {
        this.success = success;
        this.serviceMessage = serviceMessage;
        this.object = object;
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

    public String getObject() {
        return object;
    }
}
