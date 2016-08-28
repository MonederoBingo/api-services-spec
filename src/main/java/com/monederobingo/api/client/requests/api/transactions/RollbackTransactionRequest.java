package com.monederobingo.api.client.requests.api.transactions;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.auth.AuthRequest;

public class RollbackTransactionRequest extends AuthRequest
{

    public RollbackTransactionRequest(ResultListener resultListener) {
        super(resultListener);
    }

    @Override
    protected String getRequestBody() {
        return null;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getUrlPath() {
        return "acceptance_test/transaction/rollback";
    }
}
