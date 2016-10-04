package com.monederobingo.tests.use_cases.api.listing;

import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.tests.use_cases.api.ApiUseCase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CompanyUsersListing extends ApiUseCase
{

    private ServiceResult serviceResult;

    @Before
    public void setUp() {
//        CompanyUserRegistrationRequest companyUserRegistrationRequest = new CompanyUserRegistrationRequest(getApiUser());
//        companyUserRegistrationRequest.setName("Username1");
//        companyUserRegistrationRequest.setEmail("username1@monederobingo.com");
//        companyUserRegistrationRequest.send();
    }

    @Test
    public void test() {
//        serviceResult = new CompanyUserListingRequest(getApiUser()).send();
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertNotNull(serviceResult.getObject());
        JSONArray jsonArray = serviceResult.getJSONArray();
        assertCompanyUserList(jsonArray);
    }

    private void assertCompanyUserList(JSONArray jsonArray) {
        assertEquals(2, jsonArray.length());
        List<CompanyUser> sortedCompanyUserList = getSortedCompanyUserList(jsonArray);
        CompanyUser companyUser1 = sortedCompanyUserList.get(0);
        CompanyUser companyUser2 = sortedCompanyUserList.get(1);
        assertEquals(companyUser1.companyId, companyUser2.companyId);
        assertEquals(companyUser1.companyUserId, companyUser2.companyUserId - 1);

        assertEquals(getUsername(), companyUser1.name);
        assertTrue(companyUser1.active);
        assertEquals(getEmail(), companyUser1.email);

        assertEquals("Username1", companyUser2.name);
        assertFalse(companyUser2.active);
        assertEquals("username1@monederobingo.com", companyUser2.email);
    }

    private List<CompanyUser> getSortedCompanyUserList(JSONArray jsonArray) {
        CompanyUser companyUser1 = parseCompanyUser(jsonArray.getJSONObject(0));
        CompanyUser companyUser2 = parseCompanyUser(jsonArray.getJSONObject(1));
        List<CompanyUser> companyUserList = new ArrayList<>();
        companyUserList.add(companyUser1);
        companyUserList.add(companyUser2);
        sortCompanyUserList(companyUserList);
        return companyUserList;
    }

    private void sortCompanyUserList(List<CompanyUser> companyUserList) {
        Collections.sort(companyUserList, new Comparator<CompanyUser>() {
            @Override
            public int compare(CompanyUser o1, CompanyUser o2) {
                return Long.compare(o1.companyUserId, o2.companyUserId);
            }
        });
    }

    private CompanyUser parseCompanyUser(JSONObject jsonObject) {
        return new CompanyUser(
                jsonObject.getLong("companyId"),
                jsonObject.getLong("companyUserId"),
                jsonObject.getString("name"),
                jsonObject.getBoolean("active"),
                jsonObject.getString("email"));
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        return null;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }

    private class CompanyUser {
        long companyId;
        long companyUserId;
        String name;
        boolean active;
        String email;

        public CompanyUser(long companyId, long companyUserId, String name, boolean active, String email) {
            this.companyId = companyId;
            this.companyUserId = companyUserId;
            this.name = name;
            this.active = active;
            this.email = email;
        }
    }
}

