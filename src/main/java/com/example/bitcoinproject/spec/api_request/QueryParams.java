package com.example.bitcoinproject.spec.api_request;

public enum QueryParams {
    SIDE("side"),
    VOLUME("volume"),
    PRICE("price"),
    ORD_TYPE("ord_type"),
    IDENTIFIER("identifier"),
    MARKET("market"),
    MARKETS("markets"),
    TO("to"),
    COUNT("count");

    private final String paramName;

    QueryParams(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return this.paramName;
    }

}
