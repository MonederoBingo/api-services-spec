package com.lealpoints.functional_tests.clients;

import com.google.gson.Gson;
import com.lealpoints.functional_tests.model.ClientRegistration;
import com.lealpoints.functional_tests.RestApiTest;
import com.lealpoints.functional_tests.model.CompanyRegistration;
import com.lealpoints.functional_tests.model.ServiceResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetClientsByCompanyIdTest extends RestApiTest {
    @Test
    public void testGetClientsByCompanyId() {
        long companyId = registerCompany();
        registerClient(companyId, "6141112233");
        registerClient(companyId, "6624445566");

        ServiceResult serviceResult = getServiceResult(HttpMethod.POST, CallType.AUTH, "clients", companyId);
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
        assertNotNull(serviceResult.getMessage());
        assertNotNull(serviceResult.getObject());
        String actualClients = serviceResult.getObject();
    }

    private long registerCompany() {
        final CompanyRegistration companyRegistration = new CompanyRegistration();
        companyRegistration.setCompanyName("company name");
        companyRegistration.setUserName("user name");
        companyRegistration.setEmail("email@test.com");
        companyRegistration.setPassword("Pa$$w0rd");
        companyRegistration.setUrlImageLogo("images/logo.png");
        ServiceResult serviceResult = getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", companyRegistration);
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
        assertNotNull(serviceResult.getMessage());

        Gson gson = new Gson();
        CompanyRegistrationResponse companyRegistrationResponse = gson.fromJson(serviceResult.getMessage(), CompanyRegistrationResponse.class);
        return companyRegistrationResponse.companyId;
    }

    private void registerClient(long companyId, String phone) {
        final ClientRegistration clientRegistration = new ClientRegistration();
        clientRegistration.setCompanyId(companyId);
        clientRegistration.setPhone(phone);
        getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", clientRegistration);
    }

    private class CompanyRegistrationResponse {
        long companyId;
        long clientId;
    }
}
