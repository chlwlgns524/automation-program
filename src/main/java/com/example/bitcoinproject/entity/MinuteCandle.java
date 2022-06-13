package com.example.bitcoinproject.entity;

import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.spec.api_request.UnitType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "minute_candles")
@Entity
public class MinuteCandle extends Candle {

    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private UnitType unit;

    @Builder
    public MinuteCandle(MarketType market, String candleDateTimeUtc, String candleDateTimeKst, double openingPrice, double highPrice, double lowPrice, double tradePrice, long timestamp, double candleAccTradePrice, double candleAccTradeVolume, UnitType unit) {
        super(market, candleDateTimeUtc, candleDateTimeKst, openingPrice, highPrice, lowPrice, tradePrice, timestamp, candleAccTradePrice, candleAccTradeVolume);
        this.unit = unit;
    }

}
