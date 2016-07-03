package com.monederobingo.tests.use_cases.api.notifications.sms.mobile_app_advertising;

import com.monederobingo.tests.use_cases.api.ApiUseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.api.notifications.sms.SendMobileAppAdRequest;
import com.monederobingo.api.client.requests.api.points.PointsAwardingRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SuccessfulSending extends ApiUseCase
{
    private ServiceResult serviceResult;
    final String phoneNumber = "6823133323";

    @Before
    public void setUp() {
        new PointsAwardingRequest(getApiUser())
                .setPhoneNumber(phoneNumber)
                .send();
    }

    @Test
    public void test() {
        SendMobileAppAdRequest sendMobileAppAdRequest = new SendMobileAppAdRequest(getApiUser());
        sendMobileAppAdRequest.setPhoneNumber(phoneNumber);
        serviceResult = sendMobileAppAdRequest.send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertEquals("You've got 100 points. Install Monedero Bingo to see our promotions. https://goo.gl/JRssA6", serviceResult.getExtraInfo());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Mobile app ad message was successfully sent.");
        expectedMessages.put(Language.SPANISH, "El mensaje de promoción de Monedero Bingo fue enviado exitosamente.");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }

    @Override
    protected String getCompanyName() {
        return "Monedero Bingo";
    }
}

