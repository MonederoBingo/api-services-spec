package com.monederobingo.step_definitions;

import com.monederobingo.api.client.requests.api.users.CompanyUserListingRequest;
import com.monederobingo.api.client.requests.api.users.CompanyUserRegistrationRequest;
import com.monederobingo.step_definitions.domain_holders.ServiceResultHolder;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CompanyUser implements En {

    public CompanyUser(CompanyUserRegistrationRequest companyUserRegistrationRequest,
                       CompanyUserListingRequest companyUserListingRequest,
                       ServiceResultHolder serviceResult) {

        And("^User sends company user listing request$", companyUserListingRequest::send);

        And("^both users should have same companyId$",
                () -> assertEquals(getCompanyId(serviceResult, 0), getCompanyId(serviceResult, 1)));

        And("^user \"([^\"]*)\" should be inactive$",
                (String username) -> assertFalse(findUser(username, serviceResult).getBoolean("active")));

        And("^user \"([^\"]*)\" should have email \"([^\"]*)\"$",
                (String username, String email) -> assertEquals(email, findUser(username, serviceResult).getString("email")));

        Given("^User sends company user registration request$", companyUserRegistrationRequest::send);
    }

    private JSONObject findUser(String username, ServiceResultHolder serviceResult) {
        JSONArray jsonArray = serviceResult.getJSONArray();
        if (username.equals(jsonArray.getJSONObject(0).getString("name"))) {
            return jsonArray.getJSONObject(0);
        } else {
            return jsonArray.getJSONObject(1);
        }
    }

    private long getCompanyId(ServiceResultHolder serviceResult, int index) {
        return getProperty(serviceResult, index, "companyId");
    }

    private long getProperty(ServiceResultHolder serviceResult, int index, String companyId) {
        return serviceResult.getJSONArray().getJSONObject(index).getLong(companyId);
    }
}
