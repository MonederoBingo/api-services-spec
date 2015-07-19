package com.neerpoints.functional_tests.clients;

import com.google.gson.Gson;
import com.neerpoints.functional_tests.model.ClientRegistration;
import com.neerpoints.functional_tests.model.CompanyRegistration;
import com.neerpoints.functional_tests.model.ServiceResult;
import com.neerpoints.functional_tests.RestApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientRegistrationTest extends RestApiTest {
    @Test
    public void testRegisterClient() {
        long companyId = registerCompany();
        final ClientRegistration clientRegistration = new ClientRegistration();
        clientRegistration.setCompanyId(companyId);
        clientRegistration.setPhone("6141112233");
        ServiceResult response = getServiceResult(HttpMethod.POST, CallType.AUTH, "clients", clientRegistration);
        assertNotNull(response);
        assertEquals(true, response.isSuccess());
        assertNotNull(response.getMessage());
    }

    private long registerCompany() {
        final CompanyRegistration companyRegistration = new CompanyRegistration();
        companyRegistration.setCompanyName("company name");
        companyRegistration.setUserName("user name");
        companyRegistration.setEmail("email@test.com");
        companyRegistration.setPassword("Pa$$w0rd");
        companyRegistration.setUrlImageLogo("images/logo.png");
        ServiceResult response = getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", companyRegistration);
        assertNotNull(response);
        assertEquals(true, response.isSuccess());
        assertNotNull(response.getMessage());

        Gson gson = new Gson();
        CompanyRegistrationResponse companyRegistrationResponse = gson.fromJson(response.getMessage(), CompanyRegistrationResponse.class);
        return companyRegistrationResponse.companyId;
    }

    private class CompanyRegistrationResponse {
        long companyId;
        long clientId;
    }
}

