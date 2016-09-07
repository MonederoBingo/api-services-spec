package com.monederobingo.api.client.requests.auth.login;

import com.monederobingo.api.client.api_client.HttpMethod;
import com.monederobingo.api.client.requests.ResultListener;
import com.monederobingo.api.client.requests.auth.AuthRequest;
import org.json.JSONObject;

public class ClientLoginRequest extends AuthRequest {
    private String phoneNumber = "9991112233";
    private String smsKey = "123456";
    private String email = "test@lealpoints.com";
    private String password = "Password";

    public ClientLoginRequest() {
        super(ResultListener.NULL);
    }

    public ClientLoginRequest(ResultListener resultListener) {
        super(resultListener);
    }

    @Override
    protected String getRequestBody() {
        return new JSONObject()
                .put("phoneNumber", phoneNumber)
                .put("smsKey", smsKey)
                .put("email", email)
                .put("password", password)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "client/login";
    }

    public ClientLoginRequest withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientLoginRequest setSmsKey(String smsKey) {
        this.smsKey = smsKey;
        return this;
    }

    public ClientLoginRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public ClientLoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
