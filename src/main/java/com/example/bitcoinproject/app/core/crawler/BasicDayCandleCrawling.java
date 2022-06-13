package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.api_client.CandleClient;
import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.utils.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.bitcoinproject.api_client.CandleClient.MAXIMUM_COUNT;

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
            Timer.waitFor(ENOUTGH_WAIT_TIME);
        }
        requestData.addAll(candleClient.getDayCandles(market, days, to));

        return requestData;
    }

}
