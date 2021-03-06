package com.example.bitcoinproject.utils;

import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.spec.api_request.PathVariable;
import com.example.bitcoinproject.spec.api_request.QueryParams;
import com.example.bitcoinproject.spec.api_request.UnitType;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UriAppender {

    private static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd%20HH:mm:ss";

//  ex -> https://api.upbit.com/v1/candles/minutes/5?market=KRW-BTC&count=200&to=2022-05-31%2010:00:00
    public static URI getCandleUriForMinutes(URI baseUri, UnitType unit, MarketType market, int count, LocalDateTime to) {
        String fullPath = PathVariable.MINUTES.getParamName().concat(String.valueOf(unit.getValue()));

        return UriComponentsBuilder.newInstance()
                .uri(baseUri)
                .path(fullPath)
                .queryParam(QueryParams.MARKET.getParamName(), market.getValue())
                .queryParam(QueryParams.COUNT.getParamName(), count)
                .queryParam(QueryParams.TO.getParamName(), to.format(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)))
                .build(true).toUri();
    }

//  ex -> https://api.upbit.com/v1/candles/days?market=KRW-BTC&count=200&to=2022-05-31%2010:00:00
    public static URI getCandleUriForDays(URI baseUri, MarketType market, int count, LocalDateTime to) {
        return UriComponentsBuilder.newInstance()
                .uri(baseUri)
                .path(PathVariable.DAYS.getParamName())
                .queryParam(QueryParams.MARKET.getParamName(), market.getValue())
                .queryParam(QueryParams.COUNT.getParamName(), count)
                .queryParam(QueryParams.TO.getParamName(), to.format(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN)))
                .build(true).toUri();
    }

//  ex -> https://api.upbit.com/v1/ticker?markets=KRW-BTC
    public static URI getCurrentTickerUri(URI baseUri, MarketType market) {
        return UriComponentsBuilder.newInstance()
                .uri(baseUri)
                .queryParam(QueryParams.MARKETS.getParamName(), market.getValue())
                .build().toUri();
    }

}
