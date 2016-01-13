package com.lealpoints.tests.functional;

import com.lealpoints.tests.requests.api.transactions.BeginTransactionRequest;
import com.lealpoints.tests.requests.api.transactions.RollbackTransactionRequest;
import org.junit.After;
import org.junit.Before;

public class BaseApiTest {

    @Before
    public final void baseSetUp() {
        new BeginTransactionRequest().send();
    }

    @After
    public final void baseTearDown() {
        new RollbackTransactionRequest().send();
    }
}
