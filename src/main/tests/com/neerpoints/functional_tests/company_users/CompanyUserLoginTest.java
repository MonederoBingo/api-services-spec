package com.neerpoints.functional_tests.company_users;

import com.neerpoints.functional_tests.model.CompanyRegistration;
import com.neerpoints.functional_tests.model.ServiceResult;
import com.neerpoints.functional_tests.model.CompanyUserLogin;
import com.neerpoints.functional_tests.RestApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompanyUserLoginTest extends RestApiTest {
    @Test
    public void testRegisterCompany() {
        final CompanyUserLogin companyUserLogin = new CompanyUserLogin();
        final String email = "user@test.com";
        final String password = "password";
        ServiceResult responseFromRegister = registerCompanyUser(email, password);
        assertNotNull(responseFromRegister);
        assertEquals(true, responseFromRegister.isSuccess());
        assertNotNull(responseFromRegister.getMessage());

        companyUserLogin.setEmail(email);
        companyUserLogin.setPassword(password);
        ServiceResult responseFromLogin = getServiceResult(HttpMethod.POST, CallType.AUTH, "company_users/login", companyUserLogin);
        assertNotNull(responseFromLogin);
        assertEquals(true, responseFromLogin.isSuccess());
        assertNotNull(responseFromLogin.getMessage());
    }

    private ServiceResult registerCompanyUser(String email, String password) {
        final CompanyRegistration companyRegistration = new CompanyRegistration();
        companyRegistration.setCompanyName("company name");
        companyRegistration.setUserName("user name");
        companyRegistration.setEmail(email);
        companyRegistration.setPassword(password);
        companyRegistration.setUrlImageLogo("images/logo.png");
        return getServiceResult(HttpMethod.POST, CallType.AUTH, "companies", companyRegistration);
    }
}
