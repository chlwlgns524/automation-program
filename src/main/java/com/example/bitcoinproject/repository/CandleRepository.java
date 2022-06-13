package com.example.bitcoinproject.repository;

import com.example.bitcoinproject.entity.DayCandle;
import com.example.bitcoinproject.entity.MinuteCandle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CandleRepository {

    private final MinuteCandleJpaRepository minuteCandleJpaRepository;
    private final DayCandleJpaRepository dayCandleJpaRepository;

    public void saveDayCandles(List<DayCandle> dayCandles) {
        dayCandleJpaRepository.saveAll(dayCandles);
    }

    public List<DayCandle> findDayCandles() {
        return dayCandleJpaRepository.findAll();
    }

    public void saveMinuteCandles(List<MinuteCandle> minuteCandles) {
        minuteCandleJpaRepository.saveAll(minuteCandles);
    }

}
