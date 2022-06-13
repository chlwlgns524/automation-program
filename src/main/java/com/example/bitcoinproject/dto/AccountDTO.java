package com.example.bitcoinproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Setter
@Getter
public class AccountDTO {

    private String currency;

    private String balance;

    private String locked;

    @JsonProperty(value = "avg_buy_price")
    private String avgBuyPrice;

    @JsonProperty(value = "avg_buy_price_modified")
    private boolean avgBuyPriceModified;

    @JsonProperty(value = "unit_currency")
    private String unitCurrency;

}
