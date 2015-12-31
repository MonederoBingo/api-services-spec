package com.lealpoints.tests.actions.transactions;

import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;

public class TransactionAction {
    public static void beginTransaction() {
        ApiClient.getRestResponse(HttpMethod.GET, "acceptance_test/transaction/begin", "");
    }
    public static void rollbackTransaction() {
        ApiClient.getRestResponse(HttpMethod.GET, "acceptance_test/transaction/rollback", "");
    }
}
