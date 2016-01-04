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

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
