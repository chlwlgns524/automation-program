package com.example.bitcoinproject.spec.api_request;

import java.util.Arrays;

public enum UnitType {

    ONE_MINUTE(1),
    THREE_MINUTES(3),
    FIVE_MINUTES(5),
    TEN_MINUTES(10),
    FIFTEEN_MINUTES(15),
    THIRTY_MINUTES(30),
    ONE_HOUR(60),
    FOUR_HOURS(240);

    private final int value;

    UnitType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static UnitType getEnumString(int value) {
        return Arrays.stream(values())
                .filter(unitType -> unitType.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Undefined UnitType!"));
    }

}
