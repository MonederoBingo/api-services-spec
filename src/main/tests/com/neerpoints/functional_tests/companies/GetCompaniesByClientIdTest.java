package com.neerpoints.functional_tests.companies;

import java.util.List;
import com.google.gson.Gson;
import com.neerpoints.functional_tests.model.ClientRegistration;
import com.neerpoints.functional_tests.model.Company;
import com.neerpoints.functional_tests.model.CompanyRegistration;
import com.neerpoints.functional_tests.model.ServiceResult;
import com.neerpoints.functional_tests.RestApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetCompaniesByClientIdTest extends RestApiTest {
    @Test
    public void testGetCompaniesByClientId() {
        long companyId = registerClient();
        registerCompany("name1", "logo1");
        registerCompany("name2", "logo2");

        ServiceResult<List<Company>> serviceResult = getServiceResult(HttpMethod.POST, CallType.AUTH, "clients", companyId);
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
        assertNotNull(serviceResult.getMessage());
        assertNotNull(serviceResult.getObject());
        List<Company> actualCompanies = serviceResult.getObject();
        assertEquals(2, actualCompanies.size());
        assertEquals("name1", actualCompanies.get(0).getName());
        assertEquals("logo1", actualCompanies.get(0).getUrlImageLogo());
        assertEquals("name2", actualCompanies.get(1).getName());
        assertEquals("logo2", actualCompanies.get(2).getUrlImageLogo());
    }

    private long registerClient() {
        final ClientRegistration clientRegistration = new ClientRegistration();
        clientRegistration.setCompanyId(1);
        clientRegistration.setPhone("1234");
        ServiceResult serviceResult = getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", clientRegistration);

        Gson gson = new Gson();
        CompanyRegistrationResponse companyRegistrationResponse = gson.fromJson(serviceResult.getMessage(), CompanyRegistrationResponse.class);
        return companyRegistrationResponse.companyId;
    }

    private void registerCompany(String companyName, String urlImageLogo) {
        final CompanyRegistration companyRegistration = new CompanyRegistration();
        companyRegistration.setCompanyName(companyName);
        companyRegistration.setUserName("admin");
        companyRegistration.setEmail("a@a.com");
        companyRegistration.setPassword("password");
        companyRegistration.setUrlImageLogo(urlImageLogo);
        ServiceResult serviceResult = getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", companyRegistration);
        assertNotNull(serviceResult);
        assertEquals(true, serviceResult.isSuccess());
        assertNotNull(serviceResult.getMessage());
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
