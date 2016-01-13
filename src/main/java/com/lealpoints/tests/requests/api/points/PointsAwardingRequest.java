package com.lealpoints.tests.requests.api.points;

import com.lealpoints.tests.api_client.ApiUser;
import com.lealpoints.tests.requests.api.ApiRequest;
import com.lealpoints.tests.api_client.HttpMethod;
import org.json.JSONObject;

public class PointsAwardingRequest extends ApiRequest {
    private long companyId = 0;
    private String phoneNumber = "6661234567";
    private float saleAmount = 100;
    private String saleKey = "ABC";

    public PointsAwardingRequest(ApiUser apiUser) {
        super(apiUser);
    }

    @Override
    public String getRequestBody() {
        return new JSONObject()
                .put("companyId", companyId)
                .put("phoneNumber", phoneNumber)
                .put("saleAmount", saleAmount)
                .put("saleKey", saleKey)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "/api/v1/points";
    }

    public PointsAwardingRequest setCompanyId(long companyId) {
        this.companyId = companyId;
        return this;
    }

    public PointsAwardingRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PointsAwardingRequest setSaleAmount(float saleAmount) {
        this.saleAmount = saleAmount;
        return this;
    }

    public PointsAwardingRequest setSaleKey(String saleKey) {
        this.saleKey = saleKey;
        return this;
    }
}
