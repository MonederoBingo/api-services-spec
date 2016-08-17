package com.monederobingo.api.client.requests.auth.registration;

import com.monederobingo.api.client.requests.auth.AuthRequest;
import com.monederobingo.api.client.api_client.HttpMethod;
import org.json.JSONObject;

public class CompanyRegistrationRequest extends AuthRequest {
    private String companyName = "company name";
    private String email = "test@monederobingo.com";
    private String password = "Pa$$w0rd";
    private String passwordConfirmation = "Pa$$w0rd";
    private String language = "en";
    private String username = "Admin";

    @Override
    protected String getRequestBody() {
        return new JSONObject()
                .put("companyName", companyName)
                .put("urlImageLogo", "images/logo.png")
                .put("username", username)
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
        return "company/register";
    }

    public CompanyRegistrationRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyRegistrationRequest withPassword(String password) {
        this.password = password;
        return this;
    }

    public CompanyRegistrationRequest withPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
        return this;
    }

    public CompanyRegistrationRequest withLanguage(String language) {
        this.language = language;
        return this;
    }

    public CompanyRegistrationRequest withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CompanyRegistrationRequest setUsername(String userName) {
        this.username = userName;
        return this;
    }
}
