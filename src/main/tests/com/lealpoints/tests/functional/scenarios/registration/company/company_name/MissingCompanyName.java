package com.lealpoints.tests.functional.scenarios.registration.company.company_name;

import com.lealpoints.tests.actions.registration.CompanyRegistrationAction;
import com.lealpoints.tests.functional.BaseApiTest;
import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.lealpoints.tests.functional.util.CommonTests.assertServiceMessages;
import static org.junit.Assert.assertFalse;

public class MissingCompanyName extends BaseApiTest {

    private static Map<Language, String> _expectedMessages = new HashMap<>();

    static {
        _expectedMessages.put(Language.ENGLISH, "Specify the company name");
        _expectedMessages.put(Language.SPANISH, "Indique el nombre de la compañía");
    }

    @Test
    public void test() {
        final CompanyRegistrationAction.RequestData requestRequestData = CompanyRegistrationAction.getRequestData().setCompanyName("");
        ServiceResult serviceResult = CompanyRegistrationAction.registerCompany(requestRequestData);
        assertFalse(serviceResult.isSuccess());
        assertServiceMessages(serviceResult, _expectedMessages);
    }
}
