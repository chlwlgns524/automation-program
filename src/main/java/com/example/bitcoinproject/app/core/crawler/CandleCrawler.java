package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.aop.validate.ValidateTo;
import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CandleCrawler {

    private final MinuteCandleCrawling minuteCandleCrawling;
    private final DayCandleCrawling dayCandleCrawling;

    @ValidateTo
    public List<CandleDTO> crawlMinuteCandles(UnitType unit, MarketType market, LocalDateTime to, int days) {
        return minuteCandleCrawling.crawl(unit, market, to, days);
    }

    @ValidateTo
    public List<CandleDTO> crawlDayCandles(MarketType market, LocalDateTime to, int days) {
        return dayCandleCrawling.crawl(market, to, days);
    }

    public static void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
