package ru.vedeshkin.hw6.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {
    SUCCESS("success"),
    FAILED("failed");

    private final String name;


    ResponseCode(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
