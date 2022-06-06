package com.example.bitcoinproject.service;

import com.example.bitcoinproject.core.CandleCrawler;
import com.example.bitcoinproject.dto.DTOConverter;
import com.example.bitcoinproject.dto.MinuteCandleDTO;
import com.example.bitcoinproject.repository.CandleJpaRepository;
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
public class DefaultCandleCrawlingService implements CandleCrawlingService{

    private final CandleJpaRepository candleJpaRepository;
    private final CandleCrawler candleCrawler;

    @Transactional
    public int crawMinuteCandlesAndSaveInDb(UnitType unit, MarketType market, LocalDateTime to, int days) {
        List<MinuteCandleDTO> result = candleCrawler.crawlMinuteCandles(unit, market, to, days);

        candleJpaRepository.saveAll(result.stream()
                .map(DTOConverter::toFiveMinuteCandleOnMay)
                .collect(Collectors.toList()));

        return result.size();
    }

}
