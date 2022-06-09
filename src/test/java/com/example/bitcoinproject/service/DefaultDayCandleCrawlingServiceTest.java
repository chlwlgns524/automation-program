package com.example.bitcoinproject.service;

import com.example.bitcoinproject.spec.MarketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class DefaultDayCandleCrawlingServiceTest {

    @Autowired
    DayCandleCrawlingService dayCandleCrawlingService;

    @Test
    void testCrawDayCandlesAndSaveInDb() {
        LocalDateTime to = LocalDateTime.of(2022, 6, 8, 9, 0, 0);

        dayCandleCrawlingService.crawDayCandlesAndSaveInDb(MarketType.KRW_BTC, to, 159);

    }

}