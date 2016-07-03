package com.monederobingo.api.client.model;

import java.util.HashMap;
import java.util.Map;

public class ServiceMessage {
    private final String message;
    private final Map<Language, String> translations = new HashMap<>();

    public ServiceMessage(String message) {
        this.message = message;
    }

    public void addTranslation(String langId, String message) {
        translations.put(Language.getByLangId(langId), message);
    }

    public String getMessage() {
        return message;
    }

    public String getTranslation(Language language) {
        return translations.get(language);
    }
}
