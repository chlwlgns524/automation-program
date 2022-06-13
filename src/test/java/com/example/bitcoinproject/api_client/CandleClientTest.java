package com.example.bitcoinproject.core;

import com.example.bitcoinproject.api_client.CandleClient;
import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.api.MarketType;
import com.example.bitcoinproject.spec.api.UnitType;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("api 호출을 통해 요청한 분봉을 받아온다.")
    void testGetMinuteCandles() {
        List<CandleDTO> candleDTOS =
                candleClient.getMinuteCandles(UnitType.FIVE_MINUTES, MarketType.KRW_BTC, 200, LocalDateTime.now());

        candleDTOS.forEach(System.out::println);
        assertThat(candleDTOS.size()).isEqualTo(200);
    }

    @Test
    @DisplayName("api 호출을 통해 요청한 일봉을 받아온다.")
    void testGetDayCandles() {
        LocalDateTime to = LocalDateTime.of(2022, 1, 2, 9, 0, 0);

        List<CandleDTO> candleDTOS =
                candleClient.getDayCandles(MarketType.KRW_BTC, 200, to);

        candleDTOS.forEach(System.out::println);
        assertThat(candleDTOS.size()).isEqualTo(200);
    }

}