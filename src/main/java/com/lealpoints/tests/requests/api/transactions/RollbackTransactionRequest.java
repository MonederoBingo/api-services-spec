package com.lealpoints.tests.requests.api.transactions;

import com.lealpoints.tests.api_client.HttpMethod;
import com.lealpoints.tests.requests.auth.AuthRequest;

public class RollbackTransactionRequest extends AuthRequest{

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
