package com.neerpoints.functional_tests.tests.client_users;

import com.neerpoints.functional_tests.model.ClientRegistration;
import com.neerpoints.functional_tests.model.ServiceResult;
import com.neerpoints.functional_tests.model.ClientUserLogin;
import com.neerpoints.functional_tests.tests.RestApiTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientUserLoginTest extends RestApiTest {
    @Test
    public void testRegisterClient() {
        final ClientUserLogin clientUserLogin = new ClientUserLogin();
        final String phone = "6141232222";
        ServiceResult responseFromRegister = registerClientUser(phone);
        assertNotNull(responseFromRegister);
        assertEquals(true, responseFromRegister.isSuccess());
        assertNotNull(responseFromRegister.getMessage());

        clientUserLogin.setPhone(phone);
        clientUserLogin.setKey("qwerty");
        clientUserLogin.setEmail("a@a.com");
        clientUserLogin.setPassword("password");
        ServiceResult responseFromLogin = getPostResponse(clientUserLogin, "client_users/login");
        assertNotNull(responseFromLogin);
        assertEquals(true, responseFromLogin.isSuccess());
        assertNotNull(responseFromLogin.getMessage());
    }

    private ServiceResult registerClientUser(String phone) {
        final ClientRegistration clientRegistration = new ClientRegistration();
        clientRegistration.setPhone(phone);
        return getPostResponse(clientRegistration, "companies");
    }
}
