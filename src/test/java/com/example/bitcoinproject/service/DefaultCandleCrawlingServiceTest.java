package com.example.bitcoinproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.example.bitcoinproject.spec.MarketType.KRW_BTC;
import static com.example.bitcoinproject.spec.UnitType.FIVE_MINUTES;

@SpringBootTest
class DefaultCandleCrawlingServiceTest {

    @Autowired
    DefaultCandleCrawlingService defaultCandleCrawlingService;

    @Test
    void testCrawMinuteCandlesAndSaveInDb() {
        LocalDateTime to = LocalDateTime.of(2022, 5, 31, 23, 59);

        int resultSize = defaultCandleCrawlingService.crawMinuteCandlesAndSaveInDb(FIVE_MINUTES, KRW_BTC, to, 31);

        System.out.println(resultSize);
    }

}