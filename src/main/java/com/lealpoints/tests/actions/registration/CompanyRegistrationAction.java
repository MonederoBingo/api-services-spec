package com.lealpoints.tests.actions.registration;

import com.lealpoints.tests.actions.util.ParserUtil;
import com.lealpoints.tests.api.ApiClient;
import com.lealpoints.tests.api.HttpMethod;
import com.lealpoints.tests.model.ServiceResult;
import org.json.JSONObject;

public class CompanyRegistrationAction {
    private static String getJson(RequestData requestData) {
        return new JSONObject()
                .put("companyName", requestData.companyName)
                .put("urlImageLogo", requestData.urlImageLogo)
                .put("userName", requestData.userName)
                .put("email", requestData.email)
                .put("password", requestData.password)
                .put("passwordConfirmation", requestData.passwordConfirmation)
                .put("language", requestData.language)
                .toString();
    }

    public static ServiceResult registerCompany() {
        return registerCompany(new RequestData());
    }

    public static ServiceResult registerCompany(RequestData requestData) {
        String restResponse = ApiClient.getRestResponse(HttpMethod.POST, "company/register", getJson(requestData));
        return ParserUtil.toServiceResult(restResponse);
    }

    public static RequestData getRequestData() {
        return new RequestData();
    }

    public static class RequestData {
        private String companyName = "company name";
        private String urlImageLogo = "images/logo.png";
        private String userName = "user name";
        private String email = "test@lealpoints.com";
        private String password = "Pa$$w0rd";
        private String passwordConfirmation = "Pa$$w0rd";
        private String language = "en";

        public RequestData setEmail(String email) {
            this.email = email;
            return this;
        }

        public RequestData setPassword(String password) {
            this.password = password;
            return this;
        }

        public RequestData setPasswordConfirmation(String passwordConfirmation) {
            this.passwordConfirmation = passwordConfirmation;
            return this;
        }

        public RequestData setLanguage(String language) {
            this.language = language;
            return this;
        }

        public RequestData setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
    }
}
