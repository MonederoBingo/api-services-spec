package com.monederobingo.api.client.requests;

import com.monederobingo.api.client.model.ServiceResult;

public interface ResultListener {
    ResultListener NULL = serviceResult -> {
    };

    void set(ServiceResult serviceResult);
}
