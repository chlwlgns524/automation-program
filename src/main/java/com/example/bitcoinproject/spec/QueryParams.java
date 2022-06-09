package com.example.bitcoinproject.spec;

public enum QueryParams {

    MARKET("market"),
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
