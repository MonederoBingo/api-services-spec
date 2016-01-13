package com.lealpoints.tests.requests.auth.registration;

import com.lealpoints.tests.requests.auth.AuthRequest;
import com.lealpoints.tests.api_client.HttpMethod;
import org.json.JSONObject;

public class CompanyRegistrationRequest extends AuthRequest {
    private String companyName = "company name";
    private String email = "test@lealpoints.com";
    private String password = "Pa$$w0rd";
    private String passwordConfirmation = "Pa$$w0rd";
    private String language = "en";

    @Override
    protected String getRequestBody() {
        String urlImageLogo = "images/logo.png";
        String userName = "user name";
        return new JSONObject()
                .put("companyName", companyName)
                .put("urlImageLogo", urlImageLogo)
                .put("userName", userName)
                .put("email", email)
                .put("password", password)
                .put("passwordConfirmation", passwordConfirmation)
                .put("language", language)
                .toString();
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getUrlPath() {
        return "/company/register";
    }

    public CompanyRegistrationRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyRegistrationRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public CompanyRegistrationRequest setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
        return this;
    }

    public CompanyRegistrationRequest setLanguage(String language) {
        this.language = language;
        return this;
    }

    public CompanyRegistrationRequest setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
}
