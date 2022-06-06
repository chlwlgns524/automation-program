package com.example.bitcoinproject.core;

import com.example.bitcoinproject.core.UpbitCandleClient;
import com.example.bitcoinproject.dto.MinuteCandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UpbitCandleClientTest {

    @Autowired
    UpbitCandleClient upbitCandleClient;

    @Test
    void testGetMinuteCandles() {
        List<MinuteCandleDTO> minuteCandleDTOS =
                upbitCandleClient.getMinuteCandles(UnitType.FIVE_MINUTES, MarketType.KRW_BTC, 200, LocalDateTime.now());

        minuteCandleDTOS.forEach(System.out::println);
        assertThat(minuteCandleDTOS.size()).isEqualTo(200);
    }

}