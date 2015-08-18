package com.lealpoints.functional_tests.companies;

import com.lealpoints.functional_tests.RestApiTest;
import com.lealpoints.functional_tests.model.CompanyRegistration;
import com.lealpoints.functional_tests.model.ServiceResult;
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
        ServiceResult response = getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", companyRegistration);
        assertNotNull(response);
        assertEquals(true, response.isSuccess());
        assertNotNull(response.getMessage());
    }
}

