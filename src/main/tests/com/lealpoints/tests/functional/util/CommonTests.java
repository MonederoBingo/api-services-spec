package com.lealpoints.tests.functional.util;

import com.lealpoints.tests.model.Language;
import com.lealpoints.tests.model.ServiceResult;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CommonTests {
    public static void assertServiceMessages(ServiceResult serviceResult, Map<Language, String> expectedMessages) {
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResult.getMessage());
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResult.getTranslation(Language.ENGLISH));
        assertEquals(expectedMessages.get(Language.SPANISH), serviceResult.getTranslation(Language.SPANISH));
    }
}
