package com.example.bitcoinproject.dto;

import com.example.bitcoinproject.entity.BtcFiveMinuteCandle;
import com.example.bitcoinproject.spec.MarketType;

public class DTOConverter {

    public static BtcFiveMinuteCandle toFiveMinuteCandle(MinuteCandleDTO minuteCandleDTO) {
        return BtcFiveMinuteCandle.builder()
                .market(MarketType.getEnumString(minuteCandleDTO.getMarket()))
                .candleDateTimeUtc(minuteCandleDTO.getCandleDateTimeUtc())
                .candleDateTimeKst(minuteCandleDTO.getCandleDateTimeKst())
                .openingPrice(minuteCandleDTO.getOpeningPrice())
                .highPrice(minuteCandleDTO.getHighPrice())
                .lowPrice(minuteCandleDTO.getLowPrice())
                .tradePrice(minuteCandleDTO.getTradePrice())
                .timestamp(minuteCandleDTO.getTimestamp())
                .candleAccTradePrice(minuteCandleDTO.getCandleAccTradePrice())
                .candleAccTradeVolume(minuteCandleDTO.getCandleAccTradeVolume())
                .build();
    }

}
