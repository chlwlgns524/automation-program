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
public class TickerDTO {

    private String market;

    @JsonProperty(value = "trade_date")
    private String tradeDate;

    @JsonProperty(value = "trade_time")
    private String tradeTime;

    @JsonProperty(value = "trade_date_kst")
    private String tradeDateKst;

    @JsonProperty(value = "trade_time_kst")
    private String tradeTimeKst;

    @JsonProperty(value = "opening_price")
    private double openingPrice;

    @JsonProperty(value = "high_price")
    private double highPrice;

    @JsonProperty(value = "low_price")
    private double lowPrice;

    @JsonProperty(value = "trade_price")
    private double tradePrice;

    @JsonProperty(value = "prev_closing_price")
    private double prevClosingPrice;

    private String change;

    @JsonProperty(value = "change_price")
    private double changePrice;

    @JsonProperty(value = "change_rate")
    private double changeRate;

    @JsonProperty(value = "signed_change_price")
    private double signedChangePrice;

    @JsonProperty(value = "signed_change_rate")
    private double signedChangeRate;

    @JsonProperty(value = "trade_volume")
    private double tradeVolume;

    @JsonProperty(value = "acc_trade_price")
    private double accTradePrice;

    @JsonProperty(value = "acc_trade_price_24h")
    private double accTradePrice24h;

    @JsonProperty(value = "acc_trade_volume")
    private double accTradeVolume;

    @JsonProperty(value = "acc_trade_volume_24h")
    private double accTradeVolume24h;

    @JsonProperty(value = "highest_52_week_price")
    private double highest52WeekPrice;

    @JsonProperty(value = "highest_52_week_date")
    private String highest52WeekDate;

    @JsonProperty(value = "lowest_52_week_price")
    private double lowest52WeekPrice;

    @JsonProperty(value = "lowest_52_week_date")
    private String lowest52WeekDate;

    private Long timestamp;

}
