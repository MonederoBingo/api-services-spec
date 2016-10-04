package com.monederobingo.api.client.requests.api.notifications.sms;

import com.monederobingo.api.client.api_client.ApiUser;
import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.api.ApiRequest;
import org.json.JSONObject;

public class SendMobileAppAdRequest extends ApiRequest
{
    private long companyId = 0;
    private String phoneNumber = "6661234567";

    public SendMobileAppAdRequest(ApiUser apiUser, ResultListener resultListener) {
        super(apiUser, resultListener);
        companyId = Long.parseLong(apiUser.getCompanyId());
    }

    @Override
    public String getRequestBody() {
        return new JSONObject()
                .put("companyId", companyId)
                .put("phoneNumber", phoneNumber)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    protected String getUrlPath() {
        return "/api/v1/notification/" + companyId + "/" + phoneNumber + "/send_promo_sms";
    }

    public SendMobileAppAdRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
