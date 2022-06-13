package com.example.bitcoinproject.dto;

import com.example.bitcoinproject.entity.DayCandle;
import com.example.bitcoinproject.entity.MinuteCandle;
import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.spec.api_request.UnitType;

public class DTOConverter {

    public static MinuteCandle toMinuteCandleEntity(CandleDTO candleDTO) {
        return MinuteCandle.builder()
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
                .unit(UnitType.getEnumString(candleDTO.getUnit()))
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
