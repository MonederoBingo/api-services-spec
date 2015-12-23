package com.lealpoints.automated_tests.model;


import java.util.HashMap;
import java.util.Map;

public enum Language {
    ENGLISH("en"),
    SPANISH("es");

    private static Map<String, Language> languageIds = new HashMap<>();

    static {
        for (Language language : values()) {
            languageIds.put(language.getLangId(), language);
        }
    }

    private final String langId;

    Language(String langId) {
        this.langId = langId;
    }

    public static Language getByLangId(String langId) {
        return languageIds.get(langId);
    }

    public String getLangId() {
        return langId;
    }
}