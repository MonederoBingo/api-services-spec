package com.lealpoints.automated_tests.functional.common;

import com.lealpoints.automated_tests.model.Language;
import com.lealpoints.automated_tests.model.ServiceResult;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CommonTests {
    public static void testMessages(ServiceResult serviceResult, Map<Language, String> expectedMessages) {
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResult.getMessage());
        assertEquals(expectedMessages.get(Language.ENGLISH), serviceResult.getTranslation(Language.ENGLISH));
        assertEquals(expectedMessages.get(Language.SPANISH), serviceResult.getTranslation(Language.SPANISH));
    }
}
