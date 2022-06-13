package com.example.bitcoinproject.spec.api_request;

public enum SideType   {

    BID("bid"),
    ASK("ask");

    private final String value;

    SideType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
