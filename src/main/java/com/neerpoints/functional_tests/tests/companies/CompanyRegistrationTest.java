package com.neerpoints.functional_tests.tests.companies;

import com.neerpoints.functional_tests.model.CompanyRegistration;
import com.neerpoints.functional_tests.model.ServiceResult;
import com.neerpoints.functional_tests.tests.RestApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompanyRegistrationTest extends RestApiTest {
    @Test
    public void testRegisterCompany() {
        final CompanyRegistration companyRegistration = new CompanyRegistration();
        companyRegistration.setCompanyName("company name");
        companyRegistration.setUserName("user name");
        companyRegistration.setEmail("email@test.com");
        companyRegistration.setPassword("Pa$$w0rd");
        companyRegistration.setUrlImageLogo("images/logo.png");
        ServiceResult response = getPostResponse(companyRegistration, "companies");
        assertNotNull(response);
        assertEquals(true, response.isSuccess());
        assertNotNull(response.getMessage());
    }
}

