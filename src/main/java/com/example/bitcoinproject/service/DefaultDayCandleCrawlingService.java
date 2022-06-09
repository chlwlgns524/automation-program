package com.example.bitcoinproject.service;

import com.example.bitcoinproject.app.core.crawler.CandleCrawler;
import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.dto.DTOConverter;
import com.example.bitcoinproject.repository.DayCandleJpaRepository;
import com.example.bitcoinproject.spec.MarketType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DefaultDayCandleCrawlingService implements DayCandleCrawlingService {

    private final DayCandleJpaRepository dayCandleJpaRepository;
    private final CandleCrawler candleCrawler;

    @Override
    public int crawDayCandlesAndSaveInDb(MarketType market, LocalDateTime to, int days) {
        List<CandleDTO> result = candleCrawler.crawlDayCandles(market, to, days);

        dayCandleJpaRepository.saveAll(result.stream()
                .map(DTOConverter::toDayCandleEntity)
                .collect(Collectors.toList()));

        return result.size();
    }

}
