package com.example.bitcoinproject.dto;

import com.example.bitcoinproject.entity.DayCandle;
import com.example.bitcoinproject.entity.FiveMinuteCandle;
import com.example.bitcoinproject.spec.MarketType;

public class DTOConverter {

    public static FiveMinuteCandle toFiveMinuteCandleEntity(CandleDTO candleDTO) {
        return FiveMinuteCandle.builder()
                .market(MarketType.getEnumString(candleDTO.getMarket()))
                .candleDateTimeUtc(candleDTO.getCandleDateTimeUtc())
                .candleDateTimeKst(candleDTO.getCandleDateTimeKst())
                .openingPrice(candleDTO.getOpeningPrice())
                .highPrice(candleDTO.getHighPrice())
                .lowPrice(candleDTO.getLowPrice())
                .tradePrice(candleDTO.getTradePrice())
                .timestamp(candleDTO.getTimestamp())
                .candleAccTradePrice(candleDTO.getCandleAccTradePrice())
                .candleAccTradeVolume(candleDTO.getCandleAccTradeVolume())
                .build();
    }

    public static DayCandle toDayCandleEntity(CandleDTO candleDTO) {
        return DayCandle.builder()
                .market(MarketType.getEnumString(candleDTO.getMarket()))
                .candleDateTimeUtc(candleDTO.getCandleDateTimeUtc())
                .candleDateTimeKst(candleDTO.getCandleDateTimeKst())
                .openingPrice(candleDTO.getOpeningPrice())
                .highPrice(candleDTO.getHighPrice())
                .lowPrice(candleDTO.getLowPrice())
                .tradePrice(candleDTO.getTradePrice())
                .timestamp(candleDTO.getTimestamp())
                .candleAccTradePrice(candleDTO.getCandleAccTradePrice())
                .candleAccTradeVolume(candleDTO.getCandleAccTradeVolume())
                .prevClosingPrice(candleDTO.getPrevClosingPrice())
                .changePrice(candleDTO.getChangePrice())
                .changeRate(candleDTO.getChangeRate())
                .build();
    }

}
