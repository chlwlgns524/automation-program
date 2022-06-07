package com.example.bitcoinproject.core;

import com.example.bitcoinproject.dto.MinuteCandleDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.bitcoinproject.spec.MarketType.KRW_BTC;
import static com.example.bitcoinproject.spec.UnitType.FIVE_MINUTES;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UpbitCandleCrawlerTest {

    @Autowired
    UpbitCandleCrawler upbitCandleCrawler;

    @Test
    void testCrawlMinuteCandles() {
        LocalDateTime to = LocalDateTime.of(2022, 5, 31, 23, 59);
        List<MinuteCandleDTO> minuteCandleDTOS = upbitCandleCrawler.crawlMinuteCandles(FIVE_MINUTES, KRW_BTC, to, 1);

        assertThat(minuteCandleDTOS.size()).isEqualTo(288);
    }

}