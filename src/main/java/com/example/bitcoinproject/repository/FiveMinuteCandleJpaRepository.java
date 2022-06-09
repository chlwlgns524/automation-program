package com.example.bitcoinproject.repository;

import com.example.bitcoinproject.entity.BtcFiveMinuteCandle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BtcFiveMinuteCandleJpaRepository extends JpaRepository<BtcFiveMinuteCandle, Long> {
}
