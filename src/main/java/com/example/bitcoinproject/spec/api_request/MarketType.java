package com.example.bitcoinproject.spec.api;

import java.util.Arrays;

public enum MarketType {

    KRW_BTC("KRW-BTC");

    private final String value;

    MarketType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MarketType getEnumString(String value) {
        return Arrays.stream(values())
                .filter(marketType -> marketType.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Undefined MarketType!"));
    }

}
