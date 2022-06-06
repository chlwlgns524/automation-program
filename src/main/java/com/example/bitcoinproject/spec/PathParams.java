package com.example.bitcoinproject.spec;

public enum PathParams {

    MINUTES("minutes/"),
    DAYS("days/"),
    WEEKS("weeks/"),
    MONTHS("months/");

    private final String paramName;

    PathParams(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return this.paramName;
    }

}
