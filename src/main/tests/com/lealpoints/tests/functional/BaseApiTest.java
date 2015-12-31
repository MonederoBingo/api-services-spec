package com.lealpoints.tests.functional;

import com.lealpoints.tests.actions.transactions.TransactionAction;
import org.junit.After;
import org.junit.Before;

public class BaseApiTest {

    @Before
    public final void baseSetUp() {
        TransactionAction.beginTransaction();
    }

    @After
    public final void baseTearDown() {
        TransactionAction.rollbackTransaction();
    }
}
