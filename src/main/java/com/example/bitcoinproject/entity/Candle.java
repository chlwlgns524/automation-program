package com.example.bitcoinproject.entity;

import com.example.bitcoinproject.spec.MarketType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class Candle {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "market")
    private MarketType market;

    @Column(name = "candle_date_time_utc")
    private String candleDateTimeUtc;

    @Column(name = "candle_date_time_kst")
    private String candleDateTimeKst;

    @Column(name = "opening_price")
    private double openingPrice;

    @Column(name = "high_price")
    private double highPrice;

    @Column(name = "low_price")
    private double lowPrice;

    @Column(name = "trade_price")
    private double tradePrice;

    @Column(name = "timestamp")
    private long timestamp;

    @Column(name = "candle_acc_trade_price")
    private double candleAccTradePrice;

    @Column(name = "candle_acc_trade_volume")
    private double candleAccTradeVolume;

    public Candle(MarketType market, String candleDateTimeUtc, String candleDateTimeKst, double openingPrice, double highPrice, double lowPrice, double tradePrice, long timestamp, double candleAccTradePrice, double candleAccTradeVolume) {
        this.market = market;
        this.candleDateTimeUtc = candleDateTimeUtc;
        this.candleDateTimeKst = candleDateTimeKst;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradePrice = tradePrice;
        this.timestamp = timestamp;
        this.candleAccTradePrice = candleAccTradePrice;
        this.candleAccTradeVolume = candleAccTradeVolume;
    }

}
