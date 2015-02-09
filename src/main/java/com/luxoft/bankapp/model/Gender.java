package com.luxoft.bankapp.model;

public enum Gender {
    MALE("Mr."), FEMALE("Ms.");
    private String prefix;

    Gender(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
