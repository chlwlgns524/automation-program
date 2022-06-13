package com.example.bitcoinproject.spec.api_request;

public enum OrderType {

    LIMIT("limit"),
    PRICE("price"),
    MARKET("market");

    private final String value;

    OrderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
