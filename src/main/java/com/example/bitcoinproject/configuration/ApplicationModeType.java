package com.example.bitcoinproject.configuration;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum ApplicationModeType {

    BACK_TEST("BACK_TEST"),
    TRADE("TRADE"),
    CRAWL("CRAWL");

    private final String type;

    public static ApplicationModeType getEnumFromString(String type) {
        return Arrays.stream(values())
                .filter(t -> t.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Undefined Type!"));
    }

}
