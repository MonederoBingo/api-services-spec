package com.monederobingo.tests.use_cases.auth.registration.company.company_name;

import com.monederobingo.tests.use_cases.UseCase;
import com.monederobingo.api.client.model.Language;
import com.monederobingo.api.client.model.ServiceResult;
import com.monederobingo.api.client.requests.auth.registration.CompanyRegistrationRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class MissingCompanyName extends UseCase
{
    private ServiceResult serviceResult;

    @Test
    public void test() {
        serviceResult = new CompanyRegistrationRequest()
                .setCompanyName("")
                .send();
        assertFalse(serviceResult.isSuccess());
    }

    @Override
    protected Map<Language, String> getExpectedMessages() {
        Map<Language, String> expectedMessages = new HashMap<>();
        expectedMessages.put(Language.ENGLISH, "Specify the company name");
        expectedMessages.put(Language.SPANISH, "Indique el nombre de la compañía");
        return expectedMessages;
    }

    @Override
    protected ServiceResult getServiceResult() {
        return serviceResult;
    }
}

