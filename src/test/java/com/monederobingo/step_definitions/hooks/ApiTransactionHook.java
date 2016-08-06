/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions.hooks;

import com.monederobingo.api.client.requests.api.transactions.BeginTransactionRequest;
import com.monederobingo.api.client.requests.api.transactions.RollbackTransactionRequest;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ApiTransactionHook
{
    @Before
    public final void baseSetUp() {
        new BeginTransactionRequest().send();
    }

    @After
    public final void baseTearDown() {
        new RollbackTransactionRequest().send();
    }
}
