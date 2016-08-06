/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.domain_holders;

import com.monederobingo.api.client.model.ServiceResult;

public class ServiceResultHolder
{
    private ServiceResult serviceResult;

    public ServiceResult get()
    {
        return serviceResult;
    }

    public void set(ServiceResult serviceResult)
    {
        this.serviceResult = serviceResult;
    }
}
