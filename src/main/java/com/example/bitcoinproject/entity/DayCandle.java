package com.example.bitcoinproject.entity;

import com.example.bitcoinproject.spec.MarketType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "day_candles")
@Entity
public class DayCandle extends Candle {

    @Column(name = "prev_closing_price")
    private double prevClosingPrice;

    @Column(name = "change_price")
    private double changePrice;

    @Column(name = "change_rate")
    private double changeRate;

    @Builder
    public DayCandle(MarketType market, String candleDateTimeUtc, String candleDateTimeKst, double openingPrice, double highPrice, double lowPrice, double tradePrice, long timestamp, double candleAccTradePrice, double candleAccTradeVolume, double prevClosingPrice, double changePrice, double changeRate) {
        super(market, candleDateTimeUtc, candleDateTimeKst, openingPrice, highPrice, lowPrice, tradePrice, timestamp, candleAccTradePrice, candleAccTradeVolume);
        this.prevClosingPrice = prevClosingPrice;
        this.changePrice = changePrice;
        this.changeRate = changeRate;
    }

}
