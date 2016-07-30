package com.monederobingo.tests.use_cases;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.api.transactions.BeginTransactionRequest;
import com.monederobingo.api.client.requests.api.transactions.RollbackTransactionRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public abstract class UseCase
{
    private String testClassName;

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            testClassName = description.getClassName();
        }
    };

    @Before
    public final void baseSetUp() {
        new BeginTransactionRequest().send();
    }

    @After
    public final void baseTearDown() {
        new RollbackTransactionRequest().send();
        verifyServiceMessages();
    }

    private void verifyServiceMessages() {
        ServiceResult serviceResult = getServiceResult();
        Map<Language, String> expectedMessages = getExpectedMessages();
        validateExpectedMessagesWereProvided(serviceResult, expectedMessages);
        if (expectedMessages != null && !CollectionUtils.isEmpty(expectedMessages.entrySet())) {
            assertEquals(getMethodName(), expectedMessages.get(Language.ENGLISH), serviceResult.getMessage());
            assertEquals(getMethodName(), expectedMessages.get(Language.ENGLISH), serviceResult.getTranslation(Language.ENGLISH));
            assertEquals(getMethodName(), expectedMessages.get(Language.SPANISH), serviceResult.getTranslation(Language.SPANISH));
        }
    }

    private void validateExpectedMessagesWereProvided(ServiceResult serviceResult, Map<Language, String> expectedMessages) {
        if (serviceResult == null) {
            throw new RuntimeException("Yoy must provide service result from the REST API calling.");
        }
        if (serviceResult.getTranslation(Language.ENGLISH) != null
                && CollectionUtils.isEmpty(expectedMessages.entrySet()) && expectedMessages.get(Language.ENGLISH) == null) {
            throw new RuntimeException("Yoy must provide english expected messages for the service call.");
        }

        if (serviceResult.getTranslation(Language.SPANISH) != null
                && CollectionUtils.isEmpty(expectedMessages.entrySet()) && expectedMessages.get(Language.SPANISH) == null) {
            throw new RuntimeException("Yoy must provide spanish expected messages for the service call.");
        }
    }

    private String getMethodName() {
        return testClassName;
    }

    protected abstract Map<Language, String> getExpectedMessages();

    protected abstract ServiceResult getServiceResult();
}
