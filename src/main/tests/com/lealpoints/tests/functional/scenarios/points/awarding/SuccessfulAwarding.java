package com.lealpoints.tests.functional.scenarios.points.awarding;

import com.lealpoints.tests.requests.api.points.PointsAwardingRequest;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.functional.util.CommonSetup;
import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuccessfulAwarding extends BaseApiTest {
    private ApiUser apiUser;

    @Before
    public void setUp() {
        apiUser = CommonSetup.loginCompanyAndGetApiKey();
    }

    @Test
    public void test() {
        final ServiceResult serviceResult = new PointsAwardingRequest(apiUser).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
    }
}

