package com.example.bitcoinproject.spec;

public enum QueryParams {

    MARKET("market"),
    TO("to"),
    COUNT("count"),
    CONVERTING_PRICE_UNIT("convertingPriceUnit");

    private final String paramName;

    QueryParams(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return this.paramName;
    }

}