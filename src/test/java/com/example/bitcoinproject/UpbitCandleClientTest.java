package com.example.bitcoinproject;

import com.example.bitcoinproject.dto.MinuteCandle;
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
    void getMinuteCandles() {
        List<MinuteCandle> minuteCandles =
                upbitCandleClient.getMinuteCandles(5, MarketType.KRW_BTC, 200, LocalDateTime.now());

        minuteCandles.forEach(System.out::println);
        assertThat(minuteCandles.size()).isEqualTo(200);
    }

}