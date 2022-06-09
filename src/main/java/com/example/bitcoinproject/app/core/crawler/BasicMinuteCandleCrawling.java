package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static com.example.bitcoinproject.app.core.crawler.CandleClient.MAXIMUM_COUNT;
import static com.example.bitcoinproject.app.core.crawler.CandleCrawler.waitFor;

@RequiredArgsConstructor
@Component
public class BasicMinuteCandleCrawling implements MinuteCandleCrawling {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int ENOUTGH_WAIT_TIME = 100;

    private final CandleClient candleClient;

    public List<CandleDTO> crawl(UnitType unit, MarketType market, LocalDateTime to, int days) {
        List<CandleDTO> requestData = new ArrayList<>();

        int minutesConsumed = getTotalMinutesConsumed(days);
        int intervalByMaximumCount = getIntervalByMaximumCount(unit.getValue());

        while (minutesConsumed > intervalByMaximumCount) {
            requestData.addAll(candleClient.getMinuteCandles(unit, market, MAXIMUM_COUNT, to));
            minutesConsumed -= intervalByMaximumCount;
            to = to.minus(intervalByMaximumCount, ChronoUnit.MINUTES);
            waitFor(ENOUTGH_WAIT_TIME);
        }
        requestData.addAll(candleClient.getMinuteCandles(unit, market, getCountFromMinutes(minutesConsumed, unit.getValue()), to));

        return requestData;
    }

    private int getCountFromMinutes(int minutes, int unit) {
        return minutes / unit;
    }

    private int getTotalMinutesConsumed(int days) {
        return days * HOURS_PER_DAY * MINUTES_PER_HOUR;
    }

    private int getIntervalByMaximumCount(int unit) {
        return unit * MAXIMUM_COUNT;
    }

}