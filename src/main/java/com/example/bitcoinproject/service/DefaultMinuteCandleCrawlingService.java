package com.example.bitcoinproject.service;

import com.example.bitcoinproject.app.core.crawler.CandleCrawler;
import com.example.bitcoinproject.dto.DTOConverter;
import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.repository.FiveMinuteCandleJpaRepository;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DefaultCandleCrawlingService implements CandleCrawlingService {

    private final FiveMinuteCandleJpaRepository fiveMinuteCandleJpaRepository;
    private final CandleCrawler candleCrawler;

    @Transactional
    public int crawMinuteCandlesAndSaveInDb(UnitType unit, MarketType market, LocalDateTime to, int days) {
        List<CandleDTO> result = candleCrawler.crawlMinuteCandles(unit, market, to, days);

        fiveMinuteCandleJpaRepository.saveAll(result.stream()
                .map(DTOConverter::toBtcFiveMinuteCandleEntity)
                .collect(Collectors.toList()));

        return result.size();
    }

    public int crawlDayCandlesAndSaveInDb(MarketType marketType, LocalDateTime to, int days) {
        List<CandleDTO> result = candleCrawler.crawlDayCandles(marketType, to, days);
    }

}
