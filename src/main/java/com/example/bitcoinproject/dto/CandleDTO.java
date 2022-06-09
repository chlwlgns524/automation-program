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
public class CandleDTO {

//  COMMON BEGIN
    private String market;

    @JsonProperty(value = "candle_date_time_utc")
    private String candleDateTimeUtc;

    @JsonProperty(value = "candle_date_time_kst")
    private String candleDateTimeKst;

    @JsonProperty(value = "opening_price")
    private double openingPrice;

    @JsonProperty(value = "high_price")
    private double highPrice;

    @JsonProperty(value = "low_price")
    private double lowPrice;

    @JsonProperty(value = "trade_price")
    private double tradePrice;

    private long timestamp;

    @JsonProperty(value = "candle_acc_trade_price")
    private double candleAccTradePrice;

    @JsonProperty(value = "candle_acc_trade_volume")
    private double candleAccTradeVolume;
//  COMMON END

//  MINUTE BEGIN
    private int unit;
//  MINUTE END

//  DAY BEGIN
    @JsonProperty(value = "prev_closing_price")
    private double prevClosingPrice;

    @JsonProperty(value = "change_price")
    private double changePrice;

    @JsonProperty(value = "change_rate")
    private double changeRate;
// DAY END

}
