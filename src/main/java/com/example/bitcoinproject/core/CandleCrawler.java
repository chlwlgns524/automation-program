package com.example.bitcoinproject.core;

import com.example.bitcoinproject.dto.MinuteCandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CandleCrawler {

    private static final int MAXIMUM_COUNT = 200;
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int ENOUTGH_WAIT_TIME = 100;

    private final UpbitCandleClient upbitCandleClient;

    public List<MinuteCandleDTO> crawlMinuteCandles(UnitType unit, MarketType market, LocalDateTime to, int days) {
        List<MinuteCandleDTO> requestData = new ArrayList<>();

        if (to.compareTo(LocalDateTime.now()) > 0)
            return requestData;

        int minutesConsumed = getTotalMinutesConsumed(days);
        int intervalByMaximumCount = getIntervalByMaximumCount(unit.getValue());

        while (minutesConsumed > intervalByMaximumCount) {
            requestData.addAll(upbitCandleClient.getMinuteCandles(unit, market, MAXIMUM_COUNT, to));
            minutesConsumed -= intervalByMaximumCount;
            to = to.minus(intervalByMaximumCount, ChronoUnit.MINUTES);
            waitFor(ENOUTGH_WAIT_TIME);
        }
        requestData.addAll(upbitCandleClient.getMinuteCandles(unit, market, getCountFromMinutes(minutesConsumed, unit.getValue()), to));

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

    private static void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
