package com.bbb.bankingapplication.model.enumerator;

public enum Language {
    INDONESIA("IDN"),
    ENGLISH("ENG"),
    IDN("IDN"),
    ENG("ENG");

    private final String languageName;

    Language(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageName() {
        return languageName;
    }
}
