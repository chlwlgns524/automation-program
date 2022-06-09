package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class CandleCrawlerTest {

    @Autowired
    CandleCrawler candleCrawler;

    @Test
    @DisplayName(value = "to의 값이 현재 시간보다 미래의 시간일 경우 예외를 발생시킨다.")
    void testCrawlMinuteCandles1() {
        LocalDateTime to = LocalDateTime.of(2023, 6, 1, 0, 0);

        assertThatThrownBy(() -> candleCrawler.crawlMinuteCandles(UnitType.FIVE_MINUTES, MarketType.KRW_BTC, to, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid to!");
    }

    @Test
    @DisplayName(value = "입력 조건에 따라 알맞은 개수의 분봉을 반환한다.")
    void testCrawlMinuteCandles2() {
        LocalDateTime to = LocalDateTime.of(2022, 6, 1, 0, 0);

        List<CandleDTO> candleDTOS = candleCrawler.crawlMinuteCandles(UnitType.FIVE_MINUTES, MarketType.KRW_BTC, to, 1);

        assertThat(candleDTOS.size()).isEqualTo(288);
    }

    @Test
    void testCrawlDayCandles() {
        LocalDateTime to = LocalDateTime.of(2022, 5, 31, 9, 0);

        List<CandleDTO> candleDTOS = candleCrawler.crawlDayCandles(MarketType.KRW_BTC, to, 151);

        candleDTOS.forEach(System.out::println);
    }

}