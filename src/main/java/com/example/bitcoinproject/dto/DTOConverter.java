package com.example.bitcoinproject.dto;

import com.example.bitcoinproject.entity.FiveMinuteCandleOnMay;
import com.example.bitcoinproject.spec.MarketType;

public class DTOConverter {

    public static FiveMinuteCandleOnMay toFiveMinuteCandleOnMay(MinuteCandleDTO minuteCandleDTO) {
        return FiveMinuteCandleOnMay.builder()
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
