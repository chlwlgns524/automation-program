package com.example.bitcoinproject;

public enum MarketType {

    KRW_BTC("KRW-BTC");

    private final String value;

    MarketType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
