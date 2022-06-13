package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.dto.DTOConverter;
import com.example.bitcoinproject.repository.CandleRepository;
import com.example.bitcoinproject.spec.api_request.MarketType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class Crawler {

    private final CandleRepository candleRepository;
    private final CandleCrawler candleCrawler;

    public void run() {
        /*
        콘솔 프롬프트
         */
        crawlDayCandlesAndSaveInDb(MarketType.KRW_BTC, LocalDateTime.now(), 200);
    }

    public void crawlDayCandlesAndSaveInDb(MarketType market, LocalDateTime to, int days) {
        List<CandleDTO> result = candleCrawler.crawlDayCandles(market, to, days);

        candleRepository.saveDayCandles(result.stream()
                .map(DTOConverter::toDayCandleEntity)
                .collect(Collectors.toList()));
    }

}
