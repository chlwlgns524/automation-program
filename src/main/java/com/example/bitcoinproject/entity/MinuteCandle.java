package com.example.bitcoinproject.entity;

import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "five_minute_candle")
@Entity
public class FiveMinuteCandle extends Candle {

    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private UnitType unit;

    @Builder
    public FiveMinuteCandle(MarketType market, String candleDateTimeUtc, String candleDateTimeKst, double openingPrice, double highPrice, double lowPrice, double tradePrice, long timestamp, double candleAccTradePrice, double candleAccTradeVolume) {
        super(market, candleDateTimeUtc, candleDateTimeKst, openingPrice, highPrice, lowPrice, tradePrice, timestamp, candleAccTradePrice, candleAccTradeVolume);
        this.unit = UnitType.FIVE_MINUTES;
    }

}
