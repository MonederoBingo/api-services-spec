package com.lealpoints.automated_tests.functional;

import com.lealpoints.automated_tests.actions.transactions.TransactionAction;
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
