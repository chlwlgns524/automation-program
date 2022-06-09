package com.example.bitcoinproject.core;

import com.example.bitcoinproject.app.core.crawler.CandleClient;
import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(value = "test")
@SpringBootTest
class CandleClientTest {

    @Autowired
    CandleClient candleClient;

    @Test
    void testGetMinuteCandles() {
        List<CandleDTO> candleDTOS =
                candleClient.getMinuteCandles(UnitType.FIVE_MINUTES, MarketType.KRW_BTC, 200, LocalDateTime.now());

        candleDTOS.forEach(System.out::println);
        assertThat(candleDTOS.size()).isEqualTo(200);
    }

    @Test
    void testGetDayCandles() {
        LocalDateTime to = LocalDateTime.of(2022, 1, 2, 9, 0, 0);

        List<CandleDTO> candleDTOS =
                candleClient.getDayCandles(MarketType.KRW_BTC, 200, to);

        candleDTOS.forEach(System.out::println);
        assertThat(candleDTOS.size()).isEqualTo(200);
    }

}