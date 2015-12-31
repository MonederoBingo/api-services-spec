package com.lealpoints.tests.functional.scenarios.activation.activation_key;

import com.lealpoints.tests.actions.registration.company.ActivateUserAction;
import com.lealpoints.tests.actions.registration.company.RegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WrongActivationKey extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, ":/ We are very sorry, there was an error. We're trying to solve it. " +
                "You can email us to support@lealpoints.com if you want to be updated about this.");
        _expectedMessages.put(Language.SPANISH, ":/ Los sentimos, hubo un error. Estamos tratando de resolverlo, " +
                "puede enviarnos un correo a support@lealpoints.com si desea saber mas al respecto.");
    }

    @Test
    public void test() {
        RegistrationAction.registerCompany(RegistrationAction.DEFAULT_DATA);
        final ServiceResult serviceResult = ActivateUserAction.activate("DIFFERENT_ACTIVATION_KEY");
        assertServiceMessages(serviceResult, _expectedMessages);
        runAssertions(serviceResult);
    }

    private void runAssertions(ServiceResult serviceResult) {
        assertNotNull(serviceResult);
        assertFalse(serviceResult.isSuccess());
    }
}

