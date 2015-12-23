package com.lealpoints.automated_tests.functional;

import com.lealpoints.automated_tests.actions.transactions.TransactionAction;
import com.lealpoints.automated_tests.model.Language;
import com.lealpoints.automated_tests.model.ServiceResult;
import org.junit.After;
import org.junit.Before;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BaseApiTest {

    @Before
    public void setUp() {
        TransactionAction.beginTransaction();
    }

    @After
    public void tearDown() {
        TransactionAction.rollbackTransaction();
    }
}
