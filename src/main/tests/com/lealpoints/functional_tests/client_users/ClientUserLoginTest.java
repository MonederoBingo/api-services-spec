package com.lealpoints.functional_tests.client_users;

import com.lealpoints.functional_tests.RestApiTest;
import com.lealpoints.functional_tests.model.ClientRegistration;
import com.lealpoints.functional_tests.model.ClientUserLogin;
import com.lealpoints.functional_tests.model.ServiceResult;
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
        ServiceResult responseFromLogin = getServiceResult(HttpMethod.POST, CallType.AUTH, "client_users/login", clientUserLogin);
        assertNotNull(responseFromLogin);
        assertEquals(true, responseFromLogin.isSuccess());
        assertNotNull(responseFromLogin.getMessage());
    }

    private ServiceResult registerClientUser(String phone) {
        final ClientRegistration clientRegistration = new ClientRegistration();
        clientRegistration.setPhone(phone);
        return getServiceResult(HttpMethod.POST, CallType.AUTH, "client", clientRegistration);
    }
}
