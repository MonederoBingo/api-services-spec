package com.lealpoints.tests.functional.scenarios.login.client.phone_number;

import com.lealpoints.tests.actions.login.ClientUserLoginAction;
import com.lealpoints.tests.actions.registration.ClientRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.*;

public class InvalidPhoneNumber extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "Login failed! Please verify your information.");
        _expectedMessages.put(Language.SPANISH, "No se pudo iniciar sesión, verifique su correo y contraseña.");
    }

    private final String _phoneNumber = "9991234567";
    private String _smsKey;
    private final ClientRegistrationAction.RequestData _registrationRequestData = ClientRegistrationAction.getRequestData()
            .setPhoneNumber(_phoneNumber);

    @Before
    public void setUp() {
        final ServiceResult serviceResult = ClientRegistrationAction.registerClient(_registrationRequestData);
        _smsKey = serviceResult.getObject();
    }

    @Test
    public void invalidNumber() {
        testPhoneNumber("INVALID_PHONE_NUMBER");
    }

    @Test
    public void nonExistentNumber() {
        testPhoneNumber("9997654321");
    }

    private void testPhoneNumber(String phoneNumber) {
        ClientUserLoginAction.RequestData requestData = new ClientUserLoginAction.RequestData()
                .setPhoneNumber(phoneNumber)
                .setSmsKey(_smsKey);
        final ServiceResult serviceResult = ClientUserLoginAction.loginUser(requestData);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}