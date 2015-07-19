package com.neerpoints.functional_tests.clients;

import java.util.List;
import com.google.gson.Gson;
import com.neerpoints.functional_tests.model.Client;
import com.neerpoints.functional_tests.model.ClientRegistration;
import com.neerpoints.functional_tests.model.CompanyRegistration;
import com.neerpoints.functional_tests.model.ServiceResult;
import com.neerpoints.functional_tests.RestApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetClientsByCompanyIdTest extends RestApiTest {
    @Test
    public void testGetClientsByCompanyId() {
        long companyId = registerCompany();
        registerClient(companyId, "6141112233");
        registerClient(companyId, "6624445566");

        ServiceResult<List<Client>> serviceResult = getServiceResult(HttpMethod.POST, CallType.AUTH, "clients", companyId);
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
        assertNotNull(serviceResult.getMessage());
        assertNotNull(serviceResult.getObject());
        List<Client> actualClients = serviceResult.getObject();
        assertEquals(2, actualClients.size());
        assertEquals("6141112233", actualClients.get(0).getPhone());
        assertEquals("6624445566", actualClients.get(1).getPhone());
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
