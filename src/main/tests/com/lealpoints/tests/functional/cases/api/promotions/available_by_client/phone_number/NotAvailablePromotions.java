package com.lealpoints.tests.functional.cases.api.promotions.available_by_client.phone_number;

import com.lealpoints.tests.functional.cases.api.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import com.lealpoints.tests.requests.api.points.PointsAwardingRequest;
import com.lealpoints.tests.requests.api.promotions.PromotionGetAvailableByClientRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class NotAvailablePromotions extends BaseApiTest {
    private ServiceResult serviceResult;
    String phoneNumber = "6661234567";

    @Before
    public void setUp(){
        PointsAwardingRequest pointsAwardingRequest = new PointsAwardingRequest(getApiUser());
        pointsAwardingRequest.setPhoneNumber(phoneNumber);
        pointsAwardingRequest.send();
    }

    @Test
    public void test() {
        PromotionGetAvailableByClientRequest promotionGetAvailableByClientRequest =
                new PromotionGetAvailableByClientRequest(getApiUser());
        promotionGetAvailableByClientRequest.setPhoneNumber(phoneNumber);
        serviceResult = promotionGetAvailableByClientRequest.send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Client does not have available promotions.");
        expectedMessages.put(Language.SPANISH, "El cliente no alcanza ninguna promoción.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

