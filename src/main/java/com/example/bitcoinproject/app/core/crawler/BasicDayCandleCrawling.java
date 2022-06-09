package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.bitcoinproject.app.core.crawler.CandleClient.*;

@RequiredArgsConstructor
@Component
public class BasicDayCandleCrawling implements DayCandleCrawling {

    private static final int ENOUTGH_WAIT_TIME = 100;

    private final CandleClient candleClient;

    public List<CandleDTO> crawl(MarketType market, LocalDateTime to, int days) {
        List<CandleDTO> requestData = new ArrayList<>();

        while(days > MAXIMUM_COUNT) {
            requestData.addAll(candleClient.getDayCandles(market, MAXIMUM_COUNT, to));
            days -= MAXIMUM_COUNT;
            CandleCrawler.waitFor(ENOUTGH_WAIT_TIME);
        }
        requestData.addAll(candleClient.getDayCandles(market, days, to));

        return requestData;
    }

}
