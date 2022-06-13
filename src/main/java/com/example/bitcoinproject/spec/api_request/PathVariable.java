package com.example.bitcoinproject.spec.api;

public enum PathVariable {
    // EXCHANGE API PATH
    ACCOUNTS("accounts/"),
    ORDER("orders/"),

    // QUOTATION API PATH
    CANDLES("candles/"),
    MINUTES("minutes/"),
    DAYS("days/"),
    WEEKS("weeks/"),
    MONTHS("months/"),

    TICKER("ticker/");

    private final String paramName;

    PathVariable(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return this.paramName;
    }

}
